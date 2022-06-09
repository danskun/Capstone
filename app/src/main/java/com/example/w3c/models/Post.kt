package com.example.w3c

data class Post (
    val description: String = "",
    val user:  String,
    val createdAt: Long = 0L,
    val likedBy: ArrayList<String> = ArrayList())