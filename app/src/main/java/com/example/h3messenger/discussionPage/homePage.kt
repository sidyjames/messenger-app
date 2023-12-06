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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier,  onClick: (String) -> Unit) {
    val contacts = listOf("Joseph" to 3, "Momo" to 0, "Nassera" to 1)

    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp) // Ajoutez le padding en bas de l'en-tête
                .background(color = Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Liste des Conversations",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            )
        }

        // Liste de discussions avec 3 contacts
        LazyColumn {
            items(contacts) { (contact, messageCount) ->
                ConversationListItem(contact = contact, messageCount = messageCount, onClick)
            }
        }
    }
}



@Composable
fun ConversationListItem(contact: String, messageCount: Int?, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: Ajouter une action au clic de l'élément de liste */ }
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
