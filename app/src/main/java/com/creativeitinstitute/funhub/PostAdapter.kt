package com.creativeitinstitute.funhub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.creativeitinstitute.funhub.databinding.ItemPostBinding

class PostAdapter(val postList: List<PostWithUser>) : RecyclerView.Adapter<PostAdapter.PostVH>() {

    class PostVH(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        return PostVH(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        val post = postList[position]

        holder.binding.postTitle.text = post.post.postContent

        holder.binding.postImageView.load(post.post.postImageLink)
        holder.binding.userProfileImageView.load(post.user.profileImage)

        holder.binding.userName.text = post.user.name


    }

}