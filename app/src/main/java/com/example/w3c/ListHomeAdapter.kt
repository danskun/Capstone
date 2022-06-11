package com.example.w3c

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.w3c.ui.home.ThreadDetailActivity

class ListHomeAdapter(private val listHomeAdapter: ArrayList<Post>) :
    RecyclerView.Adapter<ListHomeAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_Uname)
        var tvStories: TextView = itemView.findViewById(R.id.stories)
        var tvLike : TextView = itemView.findViewById(R.id.forumLike)
        var tvComment : TextView = itemView.findViewById(R.id.forumComment)
        var imgPhoto: ImageView = itemView.findViewById(R.id.photo_user)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val home = listHomeAdapter[position]

        Glide.with(holder.itemView.context)
            .load(home.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = home.user
        holder.tvStories.text = home.stories
        holder.tvComment.text = home.comment

        val parentContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val homeDetails= Intent(parentContext, ThreadDetailActivity::class.java)
            homeDetails.putExtra(ThreadDetailActivity.EXTRA_PHOTO, home.photo)
            homeDetails.putExtra(ThreadDetailActivity.EXTRA_NAME, home.user)
            homeDetails.putExtra(ThreadDetailActivity.EXTRA_DESCRIPTION, home.description)
            homeDetails.putExtra(ThreadDetailActivity.EXTRA_COMMENT, home.comment)
            parentContext.startActivity(homeDetails)
        }
    }

    override fun getItemCount(): Int {
        return listHomeAdapter.size
    }

}