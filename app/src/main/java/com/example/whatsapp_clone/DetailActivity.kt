package com.example.whatsapp_clone

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.ui.theme.WhatsApp_cloneTheme
import com.example.whatsapp_clone.ui.theme.myColour
import java.lang.Math.atan

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setContent {
            WhatsApp_cloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = myColour) {
                    val chatId = intent.getIntExtra("extra_chatid", 0)
                    DetailView(chatId)
                    Watermark {}
                }
            }
        }
    }
}



@Composable
fun DetailView(chatId: Int) {
    val chat = DummyData.listChat.filter { it.id == chatId }[0]
    Box{
        Scaffold(

            backgroundColor = Color(0xFFe5ddd5),
            topBar = { MessageTopBar(chat = chat) },
            bottomBar = { MessageBox() },
            content = { MessageList() }
        )
    }

}

@Composable
fun MessageTopBar(chat: Chat) {
    TopAppBar(
        backgroundColor = myColour,
        title = {
            Column(Modifier.padding(start = 16.dp)) {
                Text(chat.name, fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text("last seen ${chat.time}", fontSize = 14.sp, fontWeight = FontWeight.Light, color = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,tint = Color.White)
                Image(
                    painter = painterResource(chat.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }
        },
    )
}

@Composable
fun MessageList() {
    val listMessage = DummyData.listMessage

    LazyColumn {
        items(listMessage.size) {index ->
            Spacer(modifier = Modifier.height(8.dp))
            if(listMessage[index].isPeer) {
                PeerBubble(listMessage[index])
            } else {
                UserBubble(listMessage[index])
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun UserBubble(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(80.dp, end = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0Xffd0ffc4)),
    ) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun PeerBubble(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, end = 80.dp)
            .background(color = Color.White)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun MessageBox() {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Box(Modifier.background(Color.White)) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            BasicTextField(
                value = textState.value,
                modifier = Modifier
                    .weight(1f, true)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .height(40.dp)
                    .padding(all = 10.dp),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.size(12.dp))

            FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = myColour, modifier = Modifier.size(40.dp)) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null, tint = Color.White)
            }
        }
    }
}
