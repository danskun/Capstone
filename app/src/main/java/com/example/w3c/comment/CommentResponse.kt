package com.example.w3c
data class CommentResponse(
    val status: String,
    val message: String,
    val postedData:Comment,
    val data: ArrayList<CommentList>
)