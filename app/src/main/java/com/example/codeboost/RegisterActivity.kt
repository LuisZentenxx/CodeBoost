package com.example.codeboost


import android.content.Intent
import android.os.Bundle

import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codeboost.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser



class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var btnRegister : Button
    private lateinit var txtUser : TextInputEditText
    private lateinit var txtEmail : TextInputEditText
    private lateinit var txtPassw : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        passwFocusListener()
        passwConfirmFocusListener()

        txtUser = findViewById(R.id.user)
        btnRegister = findViewById(R.id.btnRegister)
        txtEmail = findViewById(R.id.emailUser)
        txtPassw = findViewById(R.id.passwUser)

        mAuth = FirebaseAuth.getInstance()

        // Configura un listener para el botón de registro
        btnRegister.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val nameUser = txtUser.text.toString()
        val email = txtEmail.text.toString()
        val password = txtPassw.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            // Crea el usuario en Firebase
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registro exitoso
                        val user: FirebaseUser? = mAuth.currentUser

                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()

                    }
                }
        } else {
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
        }
    }

    // Confirm Password
    private fun passwConfirmFocusListener() {
        binding.passw2.setOnFocusChangeListener { _, focused ->
            if(!focused) {
                binding.txtConfirmPassw.helperText = validConfirmPassw()
            }
        }
    }
    private fun validConfirmPassw(): String? {

        val passw2 = binding.passw2.text.toString()

        if(!passw2.equals(txtPassw)){
            return "Las contraseñas no coinciden"
        }
        if(passw2.length < 0){
            return "Mínimo 6 caracteres"
        }
        if(!passw2.matches(".*[A-Z].*".toRegex())){
            return "Debe contener al menos 1 letra Mayúscula"
        }
        if(!passw2.matches(".*[a-z].*".toRegex())){
            return "Debe contener al menos 1 letra Minúscula"
        }
        if(!passw2.matches(".*[@$#%&+*.=-].*".toRegex())){
            return "Debe contener al menos 1 caracter especial (@$#%&+*.=-)"
        }
        return null
    }
    private fun passwFocusListener() {
        binding.passwUser.setOnFocusChangeListener { _, focused ->
            if(!focused) {
                binding.txtPassw.helperText = validPassw()
            }
        }
    }

    //Password
    private fun validPassw(): String? {

        val passwText = binding.passwUser.text.toString()

        if(passwText.length < 0){
            return "Mínimo 6 caracteres"
        }
        if(!passwText.matches(".*[A-Z].*".toRegex())){
            return "Debe contener al menos 1 letra Mayúscula"
        }
        if(!passwText.matches(".*[a-z].*".toRegex())){
            return "Debe contener al menos 1 letra Minúscula"
        }
        if(!passwText.matches(".*[@$#%&+*.=-].*".toRegex())){
            return "Debe contener al menos 1 caracter especial (@$#%&+*.=-)"
        }

        return null
    }

    //Email
    private fun emailFocusListener() {
        binding.emailUser.setOnFocusChangeListener { _, focused ->
            if(!focused) {
                binding.txtEmail.helperText = validEmail()
            }
        }
    }
    private fun validEmail(): String? {
        val emailText = binding.emailUser.text.toString()

        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Email Inválido"
        }
        return null
    }
}
