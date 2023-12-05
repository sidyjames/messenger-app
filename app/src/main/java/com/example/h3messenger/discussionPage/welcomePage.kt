package com.example.h3messenger.discussionPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier, onsubmit: () -> Unit) {
    var it by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenue !",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = it,
            onValueChange = { newName -> it = newName },
            label = { Text("Entrez votre nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(onClick = onsubmit) {
            Text("Y ACCEDER")
        }
    }
}