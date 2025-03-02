package com.example.languageapp

data class ChatMessage(
    val id: String = "",
    val topicId: String = "",
    val userId: String = "",
    val userName: String = "",
    val userAvatar: String = "",
    val message: String = "",
    val timestamp: Long = 0
)