package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        button?.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this@DetailActivity,
                "取关成功",
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}