package com.example.w3c.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.w3c.Comment
import com.example.w3c.CommentList
import com.example.w3c.R
import com.example.w3c.User
import com.example.w3c.databinding.ItemCommentBinding
import com.example.w3c.utils.TimeFormat.Companion.toTimeAgo

class CommentAdapter(private val listItem: ArrayList<CommentList>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCommentBinding.bind(itemView)
        fun bind(user: User, comment: Comment) {
            Glide.with(itemView.context)
                .load(user.profilePic).into(
                    binding.commentProfilePic
                )
            binding.commentUser.text = user.name
            binding.commentText.text = comment.comment
            binding.commentWaktu.text = comment.date.toTimeAgo()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            listItem[position].user,
            listItem[position].comment
        )
    }

    override fun getItemCount(): Int = listItem.size
}