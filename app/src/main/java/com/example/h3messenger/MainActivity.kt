package com.example.h3messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.h3messenger.discussionPage.DiscussionWith
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
    val currentUserForConv = remember { mutableStateOf("Fake User") }
    when (currentPage.value) {
        "login" -> Greeting { currentPage.value = "home" }
        "home" -> HomePage{user -> currentPage.value = "discussion"
        currentUserForConv.value = user as String
        }
        "discussion" ->DiscussionWith(user = currentUserForConv.value)
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
