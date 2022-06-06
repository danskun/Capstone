package com.example.w3c.post

import androidx.lifecycle.ViewModel
import com.example.w3c.Repository

class PostingViewModel(private val repo: Repository) : ViewModel() {

    fun addThread(email: String, threadTitle: String, content: String) =
        repo.addThread(email, threadTitle, content)
}