package com.example.sleepwell

data class Sleep(
    val id: String,
    var user: User,
    var start: String,
    var end: String,
    var rating: Int
)
