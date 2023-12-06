package com.example.h3messenger.discussionPage

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DiscussionWith(modifier: Modifier = Modifier, user : String) {
    Column(){

        Text(text = "chat with $user")
    }
}