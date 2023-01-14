package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val textView = findViewById<View>(R.id.brief) as TextView
    val imageView = findViewById<View>(R.id.information)
    private val upList = ArrayList<up>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUp()
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        val adapter = UpAdapter(upList)
        recyclerView.adapter = adapter
    }


    private fun initUp() {
        repeat(1) {
            upList.add(up("林慕宸", R.drawable.up1))
            upList.add(up("林浩哲", R.drawable.up2))
            upList.add(up("林迪", R.drawable.up3))
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                imageView.setImageResource(R.drawable.pig)
            //为什么《第一行代码》中复制过来会报错啊
            }
        }
    }

}