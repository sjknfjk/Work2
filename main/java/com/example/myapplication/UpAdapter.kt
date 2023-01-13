package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class UpAdapter (val upList: List<up>) :
    RecyclerView.Adapter<UpAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val UpImage: ImageView = view.findViewById(R.id.UpImage)
        val UpName: TextView = view.findViewById(R.id.UpName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.up_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val up = upList[position]

        }
        viewHolder.UpImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val up = upList[position]
            Toast.makeText(parent.context, "you clicked view ${up.name}",
                Toast.LENGTH_SHORT).show()
        }
        viewHolder.itemView.setOnLongClickListener {
            val intent = Intent()
            intent.setClass(this,DetailActivity::class.java)
            startActivity(intent)
            true
        }
        viewHolder.UpImage.setOnLongClickListener {
            val intent = Intent()
            intent.setClass(this,DetailActivity::class.java)
            startActivity(intent)
            true
        }
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = upList[position]
        holder.UpImage.setImageResource(fruit.imageId)
        holder.UpName.text = fruit.name
    }
    override fun getItemCount() = upList.size
}