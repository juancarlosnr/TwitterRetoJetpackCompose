package com.example.twiterretojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.sp

@Composable
fun TweetScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF171d27))
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ProfileCircularImage(modifier = Modifier.padding(16.dp))
                Column(Modifier.fillMaxWidth()) {
                    Header(Modifier.padding(top = 8.dp))
                    TextAndImage(Modifier)
                    miElemento(Modifier)

                }

            }
            Divider(
                Modifier
                    .height(2.dp)
                    .fillMaxWidth().alpha(0.3f),
                color = Color.LightGray,
            )
        }


    }
}

@Composable
fun miElemento(modifier: Modifier) {
    var numeroComments by remember { mutableStateOf(1) }
    var pintarComments by remember { mutableStateOf(R.drawable.ic_chat) }

    var numeroRT by remember { mutableStateOf(1) }
    var pintarRT by remember { mutableStateOf(R.drawable.ic_rt) }
    var colorRT by remember { mutableStateOf(Color.Gray) }

    var numeroMG by remember { mutableStateOf(1) }
    var pintarMG by remember { mutableStateOf(R.drawable.ic_like) }
    var colorMG by remember { mutableStateOf(Color.Gray) }



    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        //Icon Button RT
        IconButton(onClick = {
            if (numeroComments == 1) {
                numeroComments++
                pintarComments = R.drawable.ic_chat_filled

            } else {
                numeroComments--
                pintarComments = R.drawable.ic_chat
            }
        }) {
            Icon(
                painter = painterResource(id = pintarComments),
                contentDescription = "chat",
                tint = Color.Gray
            )

        }
        Text(text = numeroComments.toString(), color = Color.Gray)
        Spacer(modifier = Modifier.size(24.dp))

        IconButton(onClick = {
            if (numeroRT == 1) {
                numeroRT++
                colorRT = Color.Green

            } else {
                numeroRT--
                colorRT = Color.Gray
            }
        }) {
            Icon(
                painter = painterResource(id = pintarRT),
                contentDescription = "rt",
                tint = colorRT
            )

        }
        Text(text = numeroRT.toString(), color = Color.Gray)
        Spacer(modifier = Modifier.size(24.dp))
        IconButton(onClick = {
            if (numeroMG == 1) {
                numeroMG++
                pintarMG = R.drawable.ic_like_filled
                colorMG = Color.Red

            } else {
                numeroMG--
                pintarMG = R.drawable.ic_like
                colorMG = Color.Gray
            }
        }) {
            Icon(
                painter = painterResource(id = pintarMG),
                contentDescription = "mg",
                tint = colorMG
            )

        }
        Text(text = numeroMG.toString(), color = Color.Gray)
    }

}


@Composable
fun Header(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 3.dp, top = 8.dp)

    ) {
        Text(
            text = "Aris",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            text = "@AristiDevs",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = "4h",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "puntitos",
            Modifier.padding(start = 100.dp),
            tint = Color.White,
        )

    }

}

@Composable
fun ProfileCircularImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profile",
        modifier = modifier
            .clip(CircleShape)
            .size(65.dp)


    )
}

@Composable
fun TextAndImage(modifier: Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 3.dp)
    ) {
        Text(
            text = "Esto es una prueba dsadadasdasdadaddadadadadadadadadadadadadadad dasdadadadadada  dsad da d",
            color = Color.White,

            )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "imagentweet",
            Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
        )
    }

}


