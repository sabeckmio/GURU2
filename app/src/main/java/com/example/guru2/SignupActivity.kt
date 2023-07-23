package com.example.guru2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singup)


        val signUpButton = findViewById<Button>(R.id.signup_button)
        signUpButton.setOnClickListener{
            onSignUpButtonClick()
        }
    }

    fun onSignUpButtonClick() {
        val intent = Intent(this, SignupActivity2::class.java)
        startActivity(intent)
    }
}
