package com.pes.todoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pes.todoapp.ui.theme.ToDoAppTheme

class ContactUsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactUsContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ContactUsContent(modifier: Modifier = Modifier) {

    val ctx = LocalContext.current
    Column(modifier= modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Hello User")
        Button(onClick = {
            // make call - Implicit intent
            val callIntent = Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:1234567890"))
            ctx.startActivity(callIntent)
        }) {
            Text("Call Us")
        }

        Button(onClick = {
            // launch browser - to display website
            val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.pes.edu"))
            ctx.startActivity(browserIntent)
        }) {
            Text("Visit Website")
        }
        Button(onClick = {
            val mapIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:12.789,77.653"))
            ctx.startActivity(mapIntent)
        }) {
            Text("Locate Us")
        }
        Button(onClick = {
            val emailIntent = Intent(Intent.ACTION_SENDTO,
                Uri.parse("mailto:contact@pes.edu"))
            ctx.startActivity(emailIntent)
        }) {
            Text("Email Us")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ToDoAppTheme {
        ContactUsContent()
    }
}