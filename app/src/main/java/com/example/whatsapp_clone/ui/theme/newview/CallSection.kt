package com.example.whatsapp_clone.ui.theme.newview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.Call
import com.example.whatsapp_clone.DummyData
import com.example.whatsapp_clone.ui.theme.myColour

@Composable
fun CallView() {
    val dummyCall = DummyData.listCall

    LazyColumn {
        items(dummyCall.size) { index ->
            CallItem(dummyCall[index])
        }
    }
}

@Composable
fun CallItem(call: Call) {
    Row(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Box(modifier = Modifier.weight(2f)) {
            Image(
                painter = painterResource(call.image),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            Modifier
                .padding(horizontal = 8.dp)
                .weight(7f)
        ) {
            Text(text = call.name, maxLines = 1, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(10.dp))
                Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = if(call.isMissCall) Color.Red else Color.Green, modifier = Modifier.width(35.dp))
                Text(call.date, fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Call, contentDescription = null,
                tint = myColour
            )
        }
    }

}

