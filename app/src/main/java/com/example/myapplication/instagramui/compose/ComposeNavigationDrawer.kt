package com.example.myapplication.instagramui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeNavigationDrawer(modifier: Modifier = Modifier) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier= Modifier.weight(1f)){
                Spacer(Modifier.height(12.dp))
                Text("Drawer Title", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                HorizontalDivider()

                Text("Section 1", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                NavigationDrawerItem(
                    label = { Text("Item 1") },
                    selected = false,
                    onClick = { /* Handle click */ }
                )
                NavigationDrawerItem(
                    label = { Text("Item 2") },
                    selected = false,
                    onClick = { /* Handle click */ }
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text("Section 2", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                NavigationDrawerItem(
                    label = { Text("Settings") },
                    selected = false,
                    icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                    badge = { Text("20") }, // Placeholder
                    onClick = { /* Handle click */ }
                )
                NavigationDrawerItem(
                    label = { Text("Help and feedback") },
                    selected = false,
                    icon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                    onClick = { /* Handle click */ },
                )
                Spacer(Modifier.height(12.dp))
            }
            Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                OutlinedButton(onClick = {},) {
                    Text("Log out", color = Color.Red)
                }

            }

        }
    }
    
}