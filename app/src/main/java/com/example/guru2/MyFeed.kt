package com.example.guru2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyFeed : AppCompatActivity() {
    lateinit var myFeedTitle: TextView
    lateinit var editButton3: Button
    lateinit var plustButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_feed)

    }
}