package com.example.books

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var bookList : ArrayList<books> , var context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val current = bookList[position]
        holder.bookImg.setImageResource(current.bookImage)
        holder.bookName.text = current.title
        holder.bookAuthor.text = current.author
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val bookImg = itemView.findViewById<ImageView>(R.id.cover)
        val bookName = itemView.findViewById<TextView>(R.id.title)
        val bookAuthor = itemView.findViewById<TextView>(R.id.author)
    }


}