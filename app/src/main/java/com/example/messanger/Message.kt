package com.example.messanger

import java.util.*

class Message(var userName: String, var textMessage: String){
    var messageTime: Long = Date().time
}