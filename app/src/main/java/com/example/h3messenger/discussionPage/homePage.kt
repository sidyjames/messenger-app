package com.example.h3messenger.discussionPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.h3messenger.discussionPage.HomeViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier,  onClick: (String) -> Unit,
             viewModel : HomeViewModel = HomeViewModel()
) {


   //val contacts = users.value.map(){it to 3}

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
    ) {

        Text(
            text = state.conversations.size.toString()
        )
        // Liste de discussions avec 3 contacts
        LazyColumn {
            items(state.conversations) { conversation ->
                ConversationListItem(contact = conversation.name, messageCount = conversation.messageCount, onClick)
            }
        }
    }
}



@Composable
fun ConversationListItem(contact: String, messageCount: Int?, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(contact) }
    ) {
        // Avatar (exemple avec une icône)

        // Contenu de la conversation (nom du contact)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(text = contact)
            // Début de message
            val messagePreview = when (contact) {
                "Joseph" -> "Salut comment ça va?"
                "Momo" -> "Bro !"
                "Nassera" -> "Coucou, ça fait longtemps!"
                else -> "Aucun message"
            }
            Text(text = messagePreview, color = Color.Gray, fontSize = 12.sp)
        }

        // Heure à droite (exemple avec une heure statique)
        Text(
            text = "12:34", // Remplacez par l'heure réelle
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(50.dp)
        )

        // Nombre de messages (si disponible)
        val alpha = if (messageCount != null && messageCount != 0) 1f else 0f
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = alpha))
                .padding(end = 8.dp)
                .alpha(alpha)
        ) {
            if (messageCount != null && messageCount != 0) {
                Text(
                    text = messageCount.toString(),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}
