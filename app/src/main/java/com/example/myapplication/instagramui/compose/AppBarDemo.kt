package com.example.myapplication.instagramui.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppBarDemo(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = { Text("imbishalll", fontSize = 15.sp, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "home")
        },
        actions = {
            Icon(imageVector = Icons.Default.Settings,"setting")
            Spacer(modifier= Modifier.width(20.dp))
            Icon(imageVector = Icons.Default.AddCircle,"circle")
        }
    )

}