package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {
    lateinit var image1: ImageView
    lateinit var image2: ImageView
    private lateinit var titleText: TextView
    private lateinit var shortText: TextView
    private lateinit var longText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        image1 = findViewById(R.id.Second_image1)
        image2 = findViewById(R.id.Second_image2)
        titleText = findViewById(R.id.Second_title)
        shortText = findViewById(R.id.Second_short)
        longText = findViewById(R.id.Second_long)

        receiveData()
    }

    private fun receiveData() {
        val imageUrl1 =intent.getStringExtra("image1")
        val imageUrl2 = intent.getStringExtra("image2")
        Glide.with(this).load(imageUrl1).into(image1)
        Glide.with(this).load(imageUrl2).into(image2)
        titleText.text = intent.getStringExtra("title")
        shortText.text = intent.getStringExtra("short_description")
        longText.text = intent.getStringExtra("description")
    }
}