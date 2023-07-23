package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text

class FeedActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var chat : ImageView
    lateinit var chat_text : TextView

    private lateinit var heart1: ImageView
    private lateinit var heartText1: TextView
    private var heartCount1: Int = 12 // 기본 하트 숫자 값

    private var isHeartClicked1 : Boolean = false

    lateinit var bookmark : ImageView
    private var bookmarkClicked : Boolean = true

    lateinit var plus : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed)

        //채팅 누르면 comment 페이지로
        chat = findViewById(R.id.chat)
        chat.setOnClickListener {
            val intent = Intent(this, CommentActivity::class.java)
            startActivity(intent)
        }

        // 첫 번째 하트 이미지 뷰와 텍스트 뷰
        heart1 = findViewById(R.id.heart)
        heartText1 = findViewById(R.id.heart_text)

        heart1.setOnClickListener {
            if (isHeartClicked1) {
                heart1.setImageResource(R.drawable.heart)
                heartCount1--
            } else {
                heart1.setImageResource(R.drawable.heart_color)
                heartCount1++
            }

            isHeartClicked1 = !isHeartClicked1

            // 변경된 하트 숫자를 TextView에 반영
            heartText1.text = heartCount1.toString()
        }

        bookmark = findViewById(R.id.bookmark)
        bookmark.setOnClickListener {
            if(bookmarkClicked){
                bookmark.setImageResource(R.drawable.bookmark_color)
            }
            else{
                bookmark.setImageResource(R.drawable.bookmark)
            }
            bookmarkClicked = ! bookmarkClicked
        }

        // comment로부터 댓글 갯수 받아와서 숫자 늘리기
        chat_text= findViewById(R.id.chat_text)
        val commentCount = intent.getIntExtra("comment_count", 0)
        // 현재 댓글 갯수를 TextView에 표시
        chat_text.text = commentCount.toString()


        //plus 누르면 write 페이지로
        plus = findViewById(R.id.plus)
        plus.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

        //하단 네이게이션 바
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Home 메뉴 항목이 선택된 경우의 동작
                    true
                }
                R.id.navigation_feed -> {
                    // Feed 메뉴 항목이 선택된 경우의 동작
                    true
                }
                R.id.navigation_my -> {
                    // My 메뉴 항목이 선택된 경우의 동작
                    true
                }
                else -> false
            }
        }
    }
}
