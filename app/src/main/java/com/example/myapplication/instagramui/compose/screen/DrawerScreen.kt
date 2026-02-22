package com.example.myapplication.instagramui.compose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.instagramui.compose.ComposeAlertDialogue
import com.example.myapplication.instagramui.compose.ComposeNavigationDrawer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawerScreen(modifier: Modifier = Modifier) {
    // this is for the drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // this is for the alert dialogue

    var isShowAlertDialog by remember {
        mutableStateOf(false)
    }
    // this is for botton sheet example
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    ModalNavigationDrawer(
        drawerContent = { ComposeNavigationDrawer()},
        drawerState=drawerState
    )
    {
        Scaffold() { innerPadding ->
            Box(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column() {
                    Button(onClick = {
                        scope.launch {
                            if(drawerState.isOpen){
                                drawerState.close();
                            }else{
                                drawerState.open()
                            }
                        }
                    }) {
                        Text("Open/Close Drawer")
                    }
                    Button(onClick = {
                        isShowAlertDialog=true;
                    }) {
                        Text("Show Alert Dialog")
                    }
                    Button(onClick = {
                        showBottomSheet=true
                    }) {
                        Text("Show Bottom Sheet")
                    }

                }

                if(isShowAlertDialog){
                    ComposeAlertDialogue(
                        onDismissRequest = {
                            isShowAlertDialog=false
                        },
                        onConfirmation = {
                            isShowAlertDialog=false;
                        },
                        dialogTitle = "Deletion?",
                        dialogText = "Are you sure you want to delete?",
                        icon = Icons.Outlined.Delete

                    )
                }


                if (showBottomSheet) {
                    ModalBottomSheet(
                        modifier = Modifier.fillMaxHeight(),
                        sheetState = sheetState,
                        onDismissRequest = { showBottomSheet = false }
                    ) {
                        Text(
                            "Swipe up to open sheet. Swipe down to dismiss.",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }


            }
        }
    }
}