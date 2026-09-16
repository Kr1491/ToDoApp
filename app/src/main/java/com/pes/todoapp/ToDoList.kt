package com.pes.todoapp

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToDoListScreen(modifier: Modifier = Modifier) {

    val myItems = listOf<ToDo>(
        ToDo(1, "Study Android", "High"),
        ToDo(2, "Go to Gym", "Low"),
        ToDo(3, "Submit Project", "High", isComplete = true),
        ToDo(4, "Buy Grocery", "Low"),

    )

    // list - is now observable- State
    var listItems by remember {
        mutableStateOf(myItems)
    }

    LazyColumn (modifier = modifier
        .background(Color.LightGray)
        .fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        item {
            Text("List of Todo Items",
                fontSize = 30.sp)
        }

        items(5){
            Text("Item $it",
                fontSize = 20.sp,
                color = Color.Blue)
        }

        items(listItems, key = {
            it.id
        }){ todoItem ->
            ToDoItem(todoItem){

                listItems = listItems.filter {
                    it.id != todoItem.id
                }
            }
        }

        // footer
        item {
            Text("End of the List")
        }
    }
}

@Composable
fun ToDoItem(toDo: ToDo,
             modifier: Modifier = Modifier,
             onSelection:(ToDo) -> Unit) {
    val ctx = LocalContext.current
    // Card(), ElevationCard(), OutlinedCard()
    OutlinedCard(
        onClick = {
            // navigate to detail screen
            Toast.makeText(ctx, "${toDo.title} is clicked",
                Toast.LENGTH_LONG).show()
            onSelection(toDo)
        },
        shape = RoundedCornerShape(80.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(if (toDo.isComplete) Color.Green else Color.Red),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Column() {
                Text(toDo.title, fontSize = 25.sp)
                Text(toDo.priority)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewTodoList() {
    ToDoListScreen()
}