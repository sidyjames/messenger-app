// Navigator.kt

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.h3messenger.discussionPage.DiscussionWith
import com.example.h3messenger.discussionPage.Greeting
import com.example.h3messenger.discussionPage.HomePage
import com.example.h3messenger.discussionPage.NavigatorViewModel
import com.example.h3messenger.discussionPage.Screen

@Composable
fun Navigator() {
    val viewModel: NavigatorViewModel = viewModel()

    when (val screen = viewModel.currentScreen) {
        is Screen.Login -> Greeting { viewModel.navigateToHome() }
        is Screen.Home -> HomePage(
            onClick = { user ->
                viewModel.navigateToDiscussion(user as String)
            }
        )
        is Screen.Discussion -> DiscussionWith(user = viewModel.currentUserForConv)
        is Screen.NotFound -> Text(text = "404 not found")
    }
}
