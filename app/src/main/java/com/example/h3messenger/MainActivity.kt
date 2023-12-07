package com.example.h3messenger


import Navigator
import android.os.Bundle
import android.widget.Toast
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
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override  fun onStart(){
        super.onStart()
        auth.addAuthStateListener { authStateListener }
        auth.signInAnonymously()
            .addOnCompleteListener(this) {
                task ->
                if (!task.isSuccessful){
                    Toast.makeText(
                        baseContext,
                        "Authentication failed",
                        Toast.LENGTH_SHORT
                        ).show()
                }
            }
    }

    override  fun onStop() {
        super.onStop()
        auth.removeAuthStateListener { authStateListener }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
        }
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
   Navigator()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    H3MessengerTheme {
        ConversationApp()
    }
}
