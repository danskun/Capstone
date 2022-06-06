package com.example.w3c

import com.example.w3c.api.RemoteSource


class Repository(private val remoteSource: RemoteSource) {

    fun addThread(email: String, threadTitle: String, content: String) =
        remoteSource.addThread(email, threadTitle, content)

    fun getThread() = remoteSource.getThread()
    fun upvoteThread(threadId: String) = remoteSource.upvoteThread(threadId)
    fun addComment(threadId: String, email: String, comment: String) =
        remoteSource.addComment(threadId, email, comment)

    fun getComment(threadId: String) = remoteSource.getComment(threadId)
}