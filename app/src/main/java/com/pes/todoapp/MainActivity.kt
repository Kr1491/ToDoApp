package com.pes.todoapp


import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.pes.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    // one time execution
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        enableEdgeToEdge()
        // setContent - API - sets UI content for the screen/activity
        setContent {
            ToDoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // HomeScreen()
                    AddItemScreen(modifier = Modifier
                        .padding(innerPadding))
                }
            }
        }
    }

    // lifecycle method - automatically executed by ActivityManager
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    // save your data in onPause
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {

        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

} // Activity class completed

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Blue,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppTheme {
        Greeting("Demo")

    }
}

// no return, starts with Capital letter,
// can get re-executed - recomposition
@Composable
fun ImageDemo(){

    Image(painter = painterResource(R.drawable.ic_launcher_foreground),
        "")
}

@Composable
fun ButtonDemo(){
    // Button, OutlinedButton, ElevatedButton, IconButton
    ElevatedButton(onClick = {

    }) {
        Text("Click ME")
    }
}

@Preview
@Composable
fun PreviewImage(){
    //ImageDemo()
    ButtonDemo()
}