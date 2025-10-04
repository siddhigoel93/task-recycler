package com.example.books

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = intent.getIntExtra("image",R.drawable.alchemist)
        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val genre= intent.getStringExtra("genre")
        val about = intent.getStringExtra("about")

        val imaged = findViewById<ImageView>(R.id.cover_image)
        val titled = findViewById<TextView>(R.id.book_name)
        val authord = findViewById<TextView>(R.id.book_author)
        val genred = findViewById<TextView>(R.id.genre)
        val aboutd = findViewById<TextView>(R.id.about)

        imaged.setImageResource(image)
        titled.text=title
        authord.text = author
        genred.text = genre
        aboutd.text = about

    }
}