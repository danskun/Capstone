package com.example.w3c

import java.io.Serializable

data class Thread(
    val _id: String,
    val threadTitle: String,
    val content: String,
    val numComment: Int,
) : Serializable
