package com.example.recyclerviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Objects

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var recyclerView: RecyclerView
    private lateinit var info : ArrayList<MyDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.MyRecycler)

       loadData()
       inRecycle()

    }



    private fun inRecycle() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(info)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object :MyAdapter.OnClickListener{
            override fun onClick(position: Int, model: MyDataClass) {
                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("title",model.title)
                intent.putExtra("description",model.description)
                intent.putExtra("short_description",model.short_description)
                intent.putExtra("image1",model.image2)
                intent.putExtra("image2",model.image3)
                startActivity(intent)
            }

        })
    }

    private fun loadData() {
        info = arrayListOf()

        info.add(
            MyDataClass("https://c4.wallpaperflare.com/wallpaper/749/779/651/bangladesh-sonargaon-rice-fields-beautiful-landscape-country-in-south-asia-lush-vegetation-foliage-desktop-hd-wallpaper-1920%C3%971200-wallpaper-preview.jpg",
                "https://c1.wallpaperflare.com/preview/958/148/949/bangladesh-jute-village.jpg",
                "https://c4.wallpaperflare.com/wallpaper/546/527/806/bangladesh-beautiful-village-wallpaper-preview.jpg",
            "Bangladesh is a country in Southern Asia and is located on the Bay of Bengal bordered by India on all sides except for a small border with Burma. Bangladesh has flat plains, and most of the country is situated on deltas of large rivers flowing from the Himalayas. The government system is parliamentary democracy; the chief of state is the president, and the head of government is the prime minister. Bangladesh has a traditional economic system in which the allocation of available resources is made on the basis of inheritance and primitive methods. Bangladesh is a member of the Asia-Pacific Trade Agreement (APTA) and the South Asian Association for Regional Cooperation (SAARC).",
            "Bangladesh is a country in Southern Asia and is located on the Bay of Bengal bordered by India on all sides except for a small border with Burma.",
            "Introduction to Bangladesh",
            "Sat 6, 11:30 AM")
        )
    }
}


