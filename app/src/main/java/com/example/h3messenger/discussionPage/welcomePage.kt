package com.example.h3messenger.discussionPage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

import java.util.Date

data class Conversation(val name: String, val date: Date, val isActive: Boolean, val s: String, val messageCount: Int = 0)

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier, onsubmit: () -> Unit) {

    val it = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenue !",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = it.value,
            onValueChange = { newName -> it.value = newName },
            label = { Text("Entrez votre nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(onClick = {
            saveUsername(it.value)
            onsubmit()
        }) {
            Text("Y ACCEDER")
        }
    }
}

fun saveUsername(username: String) {
    val userId = FirebaseAuth.getInstance().currentUser?.uid
    userId?.let {
        val database = FirebaseDatabase.getInstance()
        val usersRef = database.getReference("users")
        usersRef.child(it).setValue(username)
    }
}
