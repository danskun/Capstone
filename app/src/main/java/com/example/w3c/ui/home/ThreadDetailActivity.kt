package com.example.w3c.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.w3c.R

class ThreadDetailActivity : AppCompatActivity(){

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_COMMENT = "extra_comment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_details)

        val actionbar = supportActionBar
        actionbar!!.title= "Detail Freelancer"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgPhoto: ImageView = findViewById(R.id.photo_user)
        val tvName: TextView = findViewById(R.id.tv_Uname)
        val tvDescription: TextView = findViewById(R.id.threadContent)
        val tvComment: TextView = findViewById(R.id.rv_comment)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val comment = intent.getStringExtra(EXTRA_COMMENT)

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(imgPhoto)
        tvName.text = name
        tvDescription.text = description
        tvComment.text = comment
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

