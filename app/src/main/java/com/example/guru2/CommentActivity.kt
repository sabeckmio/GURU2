package com.example.guru2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Random

class CommentActivity : AppCompatActivity(){

    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var listView: ListView

    private var list = ArrayList<String>()
    private lateinit var arrayAdapter: ArrayAdapter<String>

    private lateinit var name: String
    private lateinit var chat_msg: String
    private lateinit var chat_user: String

    private var reference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference().child("message")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment)

        listView = findViewById(R.id.list)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = arrayAdapter

        name = "Guest " + Random().nextInt(1000)

        button.setOnClickListener {
            val map: MutableMap<String, Any> = HashMap()
            val key = reference.push().key
            reference.updateChildren(map)

            val root = reference.child(key!!)
            val objectMap: MutableMap<String, Any> = HashMap()
            objectMap["name"] = name
            objectMap["text"] = editText.text.toString()

            root.updateChildren(objectMap)
            editText.setText("")

            // 데이터가 변경될 때 FeedActivity로 데이터 전달
            val intent = Intent(this, FeedActivity::class.java)
            intent.putExtra("comment_count", list.size+1) // 댓글의 개수를 전달
            startActivity(intent)
        }

        reference.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                if (dataSnapshot.exists()) {
                    chatConversation(dataSnapshot)
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
                // 데이터 변경 시 동작
                chatConversation(dataSnapshot);
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                // 데이터 삭제 시 동작
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {
                // 데이터 이동 시 동작
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // 에러 발생 시 동작
            }
        })
    }

    private fun chatConversation(dataSnapshot: DataSnapshot) {
        val i: Iterator<*> = dataSnapshot.children.iterator()
        while (i.hasNext()) {
            chat_user = ((i.next() as DataSnapshot).value as String?)!!
            chat_msg = ((i.next() as DataSnapshot).value as String?)!!
            arrayAdapter.add("$chat_user : $chat_msg")
        }
        arrayAdapter.notifyDataSetChanged()
    }
}