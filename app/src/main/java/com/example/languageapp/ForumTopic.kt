package com.example.languageapp

data class ForumTopic(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val userId: String = "",
    val userName: String = "",
    val userAvatar: String = "",
    val timestamp: Long = 0
)