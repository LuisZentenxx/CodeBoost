package com.example.codeboost


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codeboost.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
    private lateinit var typeEmail : TextInputEditText
    private lateinit var typePasswd : TextInputEditText
    private lateinit var btnLogin : Button
    private lateinit var llGoogle : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        typeEmail = findViewById(R.id.typeEmail)
        typePasswd = findViewById(R.id.typePasswd)
        btnLogin = findViewById(R.id.btnLogin)
        llGoogle = findViewById(R.id.llGoogle)

        // Login With Email And Password
        btnLogin.setOnClickListener{
            signIn()
        }

        // Login With Google Account
        llGoogle.setOnClickListener{
            signInGoogle()
        }
    }
    private fun signIn() {
        val email = typeEmail.text.toString()
        val password = typePasswd.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Inicio de sesión exitoso
                        val intent = Intent(this,HomeActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signInGoogle() {
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}