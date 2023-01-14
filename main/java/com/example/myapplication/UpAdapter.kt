package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        viewHolder.itemView.setOnClickListener { //不知道为什么此处无论长按还是单击都会闪退
            val position = viewHolder.adapterPosition
            val up = upList[position]
            MainActivity.Onclick(view)//为什么java里是可以调用实例方法的，这里不行啊
        }
        viewHolder.UpImage.setOnClickListener {     //不知道为什么此处无论长按还是单击都会闪退
            val position = viewHolder.adapterPosition
            val up = upList[position]
            MainActivity.Onclick(view)
        }
        viewHolder.itemView.setOnLongClickListener {//不知道为什么此处无论长按还是单击都会闪退
            val intent = Intent()
            intent.setClass(MainActivity(),DetailActivity::class.java)
            parent.context.startActivity(intent)
            true
        }
        viewHolder.UpImage.setOnLongClickListener {//不知道为什么此处无论长按还是单击都会闪退
            val intent = Intent()
            intent.setClass(MainActivity(),DetailActivity::class.java)
            parent.context.startActivity(intent)
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