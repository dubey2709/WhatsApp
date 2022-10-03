package com.example.whatsapp_clone

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.newCompose.AppTabBar
import com.example.whatsapp_clone.newCompose.AppTabs
import com.example.whatsapp_clone.ui.theme.WhatsApp_cloneTheme
import com.example.whatsapp_clone.ui.theme.newview.*
import com.example.whatsapp_clone.ui.theme.myColour

enum class HomeTab {
    CHATS, STATUS, CALLS
}
class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsApp_cloneTheme {
                Surface(color = myColour) {
                    HomeView(this)
                    Watermark {
                    }
                }
            }
        }
    }
}


@Composable
fun HomeView(mContext: Context) {
    var showMenu by remember{ mutableStateOf(false)}
    var tabSelected by remember { mutableStateOf(HomeTab.CHATS)}
        Scaffold (
            Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = myColour,
                title = { Image(painter = painterResource(R.drawable.camera), contentDescription = null,Modifier.width(50.dp))
                    Text("WhatsApp", style = TextStyle(color = Color.White, fontSize = 20.sp)) },
                elevation = 0.dp,
                actions = {
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "New group")

                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "New broadcast")

                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Text(text ="Linked devices" )
                            
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Text(text="Starred messages")

                        }

                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Text(text="Payments")

                        }
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Settings")
                        }

                    }
                    IconButton(onClick = {  }) {
                        Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
                    }

                    IconButton(onClick = { showMenu = showMenu != true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = null,tint = Color.White)
                    }
                }
            )

        },
            floatingActionButton = {
                when (tabSelected) {
                    HomeTab.CHATS -> {
                        FloatingActionButton(onClick = { }, backgroundColor = myColour) {
                            Icon(
                                painter = painterResource(id = R.drawable.message),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    HomeTab.STATUS-> {
                        Column {
                            FloatingActionButton(
                                onClick = {},
                                backgroundColor = Color.White,
                                modifier = Modifier.size(40.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.create),
                                    contentDescription = null,
                                    tint = Color.DarkGray
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            FloatingActionButton(
                                onClick = {  },
                                backgroundColor = myColour
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.camera),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    }
                    HomeTab.CALLS -> {
                        FloatingActionButton(onClick = {  }, backgroundColor = myColour) {
                            Icon(
                                painter = painterResource(id = R.drawable.call),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            },
        ) {
            Column(Modifier.fillMaxSize()) {
                HomeTabBar(
                    tabSelected,
                    onTabSelected = { tabSelected = it },
                )
                when (tabSelected) {
                    HomeTab.CHATS-> ChatView(mContext)

                    HomeTab.STATUS -> StatusView()
                    HomeTab.CALLS -> CallView()
                }
            }
        }
}

@Composable
fun HomeTabBar(
    tabSelected: HomeTab,
    onTabSelected: (HomeTab) -> Unit,
) {
    AppTabBar { tabBarModifier ->
        AppTabs(

            modifier = tabBarModifier,
            titles = HomeTab.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab ->
                onTabSelected(HomeTab.values()[newTab.ordinal])

            }
        )
    }
}


