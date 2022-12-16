package com.example.applearnmvp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applearnmvp.R
import com.example.applearnmvp.model.GithubUser

class MyUserAdapter (private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            notifyDataSetChanged() // Всеегда желательно использовать диф_утил
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position],itemClickListener)
    }

    override fun getItemCount(): Int {
       return users.size
    }
}

class GithubUserViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    private val userLogin by lazy {itemView.findViewById<TextView>(R.id.userLogin)}

    fun bind(item: GithubUser, clickListener: OnItemClickListener) = with(item){
        userLogin.text = login
        itemView.setOnClickListener {clickListener.onItemClicked(item)}
    }
}

interface OnItemClickListener{
    fun onItemClicked(item: GithubUser)
}
