package com.example.myapplication.instagramui

import android.R
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.instagramui.ui.theme.InstagramUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier= Modifier.fillMaxSize()) {
        Column(

        ) {
            Spacer(modifier= Modifier.padding(top = 30.dp))
            AppBar( name = "imbishalll")
            ProfileSection()
        }


    }
}


@Composable
fun AppBar(name : String,modifier: Modifier = Modifier) {
    Box (modifier = Modifier
        .padding(start = 20.dp, end = 20.dp)){
        Row(
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Text("$name", fontSize = 20.sp)
                Box {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "dropdown icon"
                    )
                    Box(modifier= Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                        .align(Alignment.CenterEnd))
                }
            }
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    modifier = Modifier.size(25.dp),
                    contentDescription = "Menu icon"
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .size(15.dp)
                        .background(Color.Red)
                        .padding(2.dp), contentAlignment = Alignment.Center,
                ) {
                    Text("1", color = Color.White, fontSize = 10.sp, textAlign = TextAlign.Center,
                        style = TextStyle(platformStyle = PlatformTextStyle(
                            includeFontPadding = false)
                        )
                    )
                }
            }
        }
    }
    
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Box(modifier= Modifier.padding(start = 20.dp,end=20.dp)){
        Row (verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Gray)) {

            }
            Spacer(modifier= Modifier.width(20.dp).background(Color.Red))
            Row(modifier= Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceAround){
                Column(modifier= Modifier,horizontalAlignment = Alignment.CenterHorizontally){
                    Text("1,611", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Post")
                }
                Column(modifier = Modifier,horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("924", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Followers")
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("678", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Following")
                }


            }

        }


    }
    
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    InstagramUITheme {
        Greeting("Android")
    }
}