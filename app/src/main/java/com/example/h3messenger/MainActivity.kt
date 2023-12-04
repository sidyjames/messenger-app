package com.example.h3messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.h3messenger.ui.theme.H3MessengerTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            H3MessengerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("h3 messenger" , modifier=Modifier.padding(70.dp,200.dp,50.dp,100.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String,modifier: Modifier = Modifier) {
    var it by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = "Bienvenue sur $name !",
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
        Button(onClick = {  }) {
            Text("Y ACCEDER")
        }
    }
}

@Composable
fun Navigation(){
    val currentPage = remember { mutableStateOf("") }
    when (currentPage.value){
        "login" -> GreetingPreview()
        "home" -> HomePage()

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier){
    var it by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
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
        Button(onClick = {  }) {
            Text("")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    H3MessengerTheme {
        if (true) Greeting("Android") else HomePage()
    }
}