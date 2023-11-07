package com.example.codeboost

import LanguageAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeginnerHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_beginner)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewLanguages)

        val languageList = listOf(
            Language(R.drawable.python_logo, "Python"),
            Language(R.drawable.kotlin_logo, "Kotlin"),
            Language(R.drawable.github_logo, "Git"),
            Language(R.drawable.robot, "Java"),
            Language(R.drawable.robot, "Javascript"),
        )

        val adapter = LanguageAdapter(languageList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}