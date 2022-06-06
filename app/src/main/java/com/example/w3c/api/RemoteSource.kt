package com.example.w3c.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.w3c.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Thread

class RemoteSource(private val apiService: ApiService) {


    fun addThread(email: String, threadTitle: String, content: String): LiveData<Boolean> {
        val threadSentiment = MutableLiveData<Boolean>()
        val client = apiService.addThread(email, threadTitle, content)
        client.enqueue(object : Callback<ThreadResponse> {
            override fun onResponse(
                call: Call<ThreadResponse>,
                response: Response<ThreadResponse>
            ) {
                val res = response.body() as ThreadResponse
                if (res.status == "error") {
                    threadSentiment.postValue(true)
                } else {
                    threadSentiment.postValue(false)
                }
            }

            override fun onFailure(call: Call<ThreadResponse>, t: Throwable) {
                Log.e("API_FAILURE", t.toString())
            }
        })
        return threadSentiment
    }

    fun getThread(): LiveData<ArrayList<ThreadList>> {
        val thread = MutableLiveData<ArrayList<ThreadList>>()
        val client = apiService.getThread()
        client.enqueue(object : Callback<ThreadResponse> {
            override fun onResponse(
                call: Call<ThreadResponse>,
                response: Response<ThreadResponse>
            ) {
                val obj = response.body() as ThreadResponse
                thread.postValue(obj.data)
            }

            override fun onFailure(call: Call<ThreadResponse>, t: Throwable) {
                Log.e("API_FAILURE", t.toString())
            }
        })
        return thread
    }

    fun upvoteThread(threadId: String) {
        val client = apiService.upvoteThread(threadId)
        client.enqueue(object : Callback<Thread> {
            override fun onResponse(call: Call<Thread>, response: Response<Thread>) {

            }

            override fun onFailure(call: Call<Thread>, t: Throwable) {
                Log.e("API_FAILURE", t.toString())
            }

        })
    }

    fun addComment(threadId: String, email: String, comment: String): LiveData<Boolean> {
        val commentSentiment = MutableLiveData<Boolean>()
        val client = apiService.addComment(threadId, email, comment)
        client.enqueue(object : Callback<CommentResponse> {
            override fun onResponse(
                call: Call<CommentResponse>,
                response: Response<CommentResponse>
            ) {
                val res = response.body() as CommentResponse
                if (res.status == "error") {
                    commentSentiment.postValue(true)
                } else {
                    commentSentiment.postValue(false)
                }
            }

            override fun onFailure(call: Call<CommentResponse>, t: Throwable) {
                Log.e("API_FAILURE", t.toString())
            }

        })
        return commentSentiment
    }

    fun getComment(threadId: String): LiveData<ArrayList<CommentList>> {
        val comment = MutableLiveData<ArrayList<CommentList>>()
        val client = apiService.getComment(threadId)
        client.enqueue(object : Callback<CommentResponse> {
            override fun onResponse(
                call: Call<CommentResponse>,
                response: Response<CommentResponse>
            ) {
                val obj = response.body() as CommentResponse
                comment.postValue(obj.data)
            }

            override fun onFailure(call: Call<CommentResponse>, t: Throwable) {
                Log.e("API_FAILURE", t.toString())
            }
        })
        return comment
    }

}