package com.pes.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pes.todoapp.ui.theme.ToDoAppTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {

    var emailID by remember {
        mutableStateOf("")
    }

    val ctx = LocalContext.current

    Column(modifier = modifier.fillMaxSize()
        .background(Color.LightGray),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("User Profile", fontSize = 30.sp)

        Box(modifier = Modifier.size(150.dp)){
            Icon(imageVector = Icons.Default.Person,
                modifier = Modifier.size(140.dp),
                contentDescription = "Default image")
        }
        Text("Tap Image to change")
        OutlinedTextField(emailID,
            placeholder = {
                Text("Email ID")
            },
            onValueChange = {
            emailID = it
        })

        Button(onClick = {
            // launch ContactUsActivity
            val i = Intent(ctx,
                ContactUsActivity::class.java)
            ctx.startActivity(i)
        }) {
            Text("Contact Us", fontSize = 25.sp)
        }

    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    ToDoAppTheme {
        ProfileContent()
    }
}