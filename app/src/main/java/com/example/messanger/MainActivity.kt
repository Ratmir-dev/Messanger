package com.example.messanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.Auth
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    var sinCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainId: RelativeLayout = findViewById(R.id.main)
        //Пользователь еще не авторизован
        if(FirebaseAuth.getInstance().currentUser == null){
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), sinCode)
        }
        else {
            Snackbar.make(mainId, "Вы авторизованы", Snackbar.LENGTH_LONG).show()
        }
        displayallmessages()
    }

    private fun displayallmessages() {
        
    }
}
