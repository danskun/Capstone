package com.example.w3c

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.concurrent.Task


class UserDao {

    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    fun addUser(user: User?) {
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                usersCollection.document(user.uid).set(it)
            }
        }
    }

    fun getUserById(uId: String): Task<DocumentSnapshot> {
        return usersCollection.document(uId).get()
    }

}