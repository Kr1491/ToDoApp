package com.pes.todoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {


    Column(modifier = Modifier
        .background(Color.Yellow)
        .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome", fontSize = 30.sp)
        Spacer(modifier= Modifier.size(80.dp))
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(80.dp))
        Button(onClick = {

        }) {
            Row {
                Image(painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = null)
                Text("CONTINUE")
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}