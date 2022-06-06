package com.example.w3c

data class ThreadResponse(
    val status: String,
    val message: String,
    val postedData: String,
    val data: ArrayList<ThreadList>
)
