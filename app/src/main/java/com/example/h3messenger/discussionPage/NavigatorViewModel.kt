package com.example.h3messenger.discussionPage
// NavigatorViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed class Screen {
    object Login : Screen()
    object Home : Screen()
    data class Discussion(val user: String) : Screen()
    object NotFound : Screen()
}

class NavigatorViewModel : ViewModel() {

    var currentScreen by mutableStateOf<Screen>(Screen.Login)
        private set

    var currentUserForConv by mutableStateOf("Fake User")
        private set

    fun navigateToHome() {
        currentScreen = Screen.Home
    }

    fun navigateToDiscussion(user: String) {
        currentScreen = Screen.Discussion(user)
        currentUserForConv = user
    }
}

