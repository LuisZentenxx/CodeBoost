package com.example.codeboost

import LanguageAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BoosterHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_booster)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewLenguaje)

        val languageList = listOf(
            Language(R.drawable.python_logo, "Python Data Science"),
            Language(R.drawable.kotlin_logo, "Kotlin + Jetpack"),
            Language(R.drawable.github_logo, "Git Bash"),
            Language(R.drawable.robot, "Java Avanzado"),
            Language(R.drawable.robot, "Typescript"),
        )

        val adapter = LanguageAdapter(languageList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}