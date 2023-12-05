package com.example.h3messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.h3messenger.discussionPage.ConversationListItem
import com.example.h3messenger.discussionPage.Greeting
import com.example.h3messenger.discussionPage.HomePage
import com.example.h3messenger.ui.theme.H3MessengerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            H3MessengerTheme {
                // A surface container using the 'background' color from the theme
                ConversationApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun ConversationApp() {
    val currentPage = remember { mutableStateOf("login") }
    when (currentPage.value) {
        "login" -> Greeting { currentPage.value = "home" }
        "home" -> HomePage()
        //"discussion" -> DiscussionPage()
        else -> Text(text = "404 not found")

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    H3MessengerTheme {
        ConversationApp()
    }
}
