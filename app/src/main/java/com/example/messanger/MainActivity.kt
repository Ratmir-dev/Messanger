package com.example.messanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.Auth
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseError
import com.google.firebase.auth.FirebaseAuth
import android.widget.TextView
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.text.format.DateFormat
import android.view.View
import com.firebase.ui.database.FirebaseListAdapter
import com.firebase.ui.database.FirebaseListOptions
import kotlinx.android.synthetic.main.list_item2.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val query = FirebaseDatabase.getInstance().getReference()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSend: FloatingActionButton = this.findViewById(R.id.btn_send)
        var textField: TextInputEditText = findViewById(R.id.messageField)
        btnSend.setOnClickListener(View.OnClickListener {
            Log.e("Main", "Кнопка обработалась")
            if (textField.text.toString() == "")
                return@OnClickListener
            /*query.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot != null) {
                        val message = dataSnapshot.value
                        Log.e("Read Firebase", message.toString())
                    }
                    else{
                        Log.e("You", "gay")
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    // Failed to read value
                }
            })*/
            FirebaseDatabase.getInstance().getReference().push().setValue(Message("Ramzes",
                textField.text.toString()
            ))
            textField.setText("")
        })



           // FirebaseDatabase.getInstance().getReference("users").addValueEventListener(messageListener)

            //displayallmessages()
    }

    private fun displayallmessages() {
        var listview: ListView = findViewById(R.id.messageList)
        val adapter: FirebaseListAdapter<ChatList>
        val options = FirebaseListOptions.Builder<ChatList>()
            .setQuery(query, ChatList::class.java)
            .setLayout(R.layout.list_item)
            .build()
        adapter = object : FirebaseListAdapter<ChatList>(options) {
            override fun populateView(v: View, model: ChatList, position: Int) {
                var username:TextView = v.findViewById(R.id.username)
                var usermessage:TextView = v.findViewById(R.id.usermessage)
                username.text = model.userName
                usermessage.text = model.textMessage

            }
        }
        listview.adapter = adapter

        }
    }
