package com.example.w3c

import java.io.Serializable

data class User(
    val _id: String,
    val profilePic: String,
    val name: String,
    val registerDate: String
) : Serializable
