package com.example.guru2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MyPage : AppCompatActivity() {

    //lateinit var nickname: EditText
    lateinit var myFeedButton: Button
    lateinit var bookMarkButton: Button
    //lateinit var backButton: ImageButton
    lateinit var editButton: ImageButton
    lateinit var myPhotoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page)

        myPhotoButton = findViewById<Button>(R.id.myPhotoButton)
        myFeedButton = findViewById<Button>(R.id.myFeedButton)
        bookMarkButton = findViewById<Button>(R.id.bookMarkButton)


        myPhotoButton.setOnClickListener {
            var intent = Intent(this, MyPhoto::class.java)
            startActivity(intent)
        }

        myFeedButton.setOnClickListener {
            var intent = Intent(this, MyFeed::class.java)
            startActivity(intent)
        }
        bookMarkButton.setOnClickListener{
            var intent = Intent( this, BookMark::class.java)
            startActivity(intent)
        }

    }

}