package com.example.codeboost

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {

    private lateinit var btnLogOut : Button
    private lateinit var cardBeginner : CardView
    private lateinit var cardBooster : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnLogOut = findViewById(R.id.btnLogOut)
        cardBeginner = findViewById(R.id.cardBeginner)
        cardBooster = findViewById(R.id.cardBooster)

        cardBeginner.setOnClickListener{
            Toast.makeText(this, "Mucho éxito!", Toast.LENGTH_LONG).show()
            intent = Intent(this, BeginnerHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        cardBooster.setOnClickListener{
            Toast.makeText(this, "Éxito Booster!", Toast.LENGTH_LONG).show()
            intent = Intent(this, BoosterHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogOut.setOnClickListener {
                Firebase.auth.signOut()
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}