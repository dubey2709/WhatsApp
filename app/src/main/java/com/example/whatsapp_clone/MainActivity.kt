package com.example.whatsapp_clone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapp_clone.newCompose.Centre
import com.example.whatsapp_clone.ui.theme.WhatsApp_cloneTheme
import com.example.whatsapp_clone.ui.theme.greenColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsApp_cloneTheme {
                val composableScope=rememberCoroutineScope()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                   SplashNew()
                    composableScope.launch{
                        delay(1000)
                        startActivity(Intent(this@MainActivity,HomeScreen::class.java))



                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun SplashNew(){
Centre(
    modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
) {
    Column() {
        Column(Modifier.height(250.dp)) {
        }
        Image(painter = painterResource(id =R.drawable.logo ), contentDescription =null, modifier = Modifier.size(100.dp) )
        Column(Modifier.height(300.dp)) {
        }
        Image(painter = painterResource(id =R.drawable.whatsapp), contentDescription =null, modifier = Modifier.size(120.dp) )
    }

}
}


