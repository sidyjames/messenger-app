package com.example.h3messenger.discussionPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date

//data class Conversation(val name: String, val messageCount: Int)
class HomeViewModel():ViewModel(){

    private val _uiState = MutableStateFlow(HomeState())
    val uiState : StateFlow<HomeState> = _uiState.asStateFlow()

    init{//executer un autre thread autre que le principal
        viewModelScope.launch {
            val database = FirebaseDatabase.getInstance()
            val usersRef = database.getReference("users")
            val onSuccess = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val users = snapshot.children.toList().map{
                        it.value as String
                    }
                    val convs = users.map{
                        Conversation(name = it, Date(), true, "no conv")
                    }
                    _uiState.update {
                        it.copy(conversations = convs)
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error fetching data : ${error.message}")
                }
            }
            usersRef.addValueEventListener(onSuccess)

        }
    }
}
data class HomeState(val conversations : List<Conversation> =listOf())
