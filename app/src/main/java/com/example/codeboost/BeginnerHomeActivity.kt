package com.example.codeboost

import LanguageAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeginnerHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_beginner)

        /* Es una vista para mostrar listas de elementos desplazables */
        val recyclerView : RecyclerView = findViewById(R.id.recyclerViewLanguages)

        /* Cada elemento de la lista es una instancia de Lenguaje */
        val listaLenguaje = listOf(
            Lenguaje(R.drawable.python_logo, "Python"),
            Lenguaje(R.drawable.kotlin_logo, "Kotlin"),
            Lenguaje(R.drawable.github_logo, "Git"),
            Lenguaje(R.drawable.java_logo, "Java"),
            Lenguaje(R.drawable.javascript_logo, "Javascript"),
            Lenguaje(R.drawable.golang, "Golang"),
            Lenguaje(R.drawable.react_logo, "React"),
            Lenguaje(R.drawable.bash_logo, "Bash"),
            Lenguaje(R.drawable.csh_logo, "C#"),
            Lenguaje(R.drawable.html_logo, "HTML"),
        )

        /* Se encarga de tomar los elementos de la lista y preparar la vista para cada uno de ellos.*/
        val adapter = LanguageAdapter(listaLenguaje)

        /* Muestra los elementos de la lista utilizando la lógica definida en el adaptador.*/
        recyclerView.adapter = adapter

        /* Esto determina cómo se organizarán y mostrarán los elementos en el RecyclerView. */
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}