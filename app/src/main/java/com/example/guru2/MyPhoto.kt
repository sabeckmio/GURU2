package com.example.guru2

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MyPhoto : AppCompatActivity() {

    lateinit var myPhotoTitle: TextView
    lateinit var editTextTime: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_photo)

    }

}