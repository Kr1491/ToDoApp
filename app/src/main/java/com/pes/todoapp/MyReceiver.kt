package com.pes.todoapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.util.Locale

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // finish execution within 10 secs
        Toast.makeText(context, "Language changed",
            Toast.LENGTH_LONG).show()

        val lang = Locale.getDefault().toLanguageTag()

        Log.d("MyReceiver", "Changed language: $lang")
    }

}