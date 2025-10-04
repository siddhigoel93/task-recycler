package com.example.books

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var bookList: ArrayList<books>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myRecyclerView = findViewById(R.id.recyclerView)

        var bookImageArray = arrayOf(
            R.drawable.alchemist,
            R.drawable.atomichabits,
            R.drawable.itendswithus,
            R.drawable.kiterunner,
            R.drawable.hobbit,
            R.drawable.mockingbird,
            R.drawable.richdadpoordad,
            R.drawable.annefrank
        )

        var bookTitleArray = arrayOf(
            "The Alchemist",
            "Atomic Habits",
            "It ends with us",
            "The Kite Runner",
            "The Hobbit",
            "To Kill a Mockingbird",
            "Rich Dad Poor Dad",
            "The Diary of a Young Girl"
        )

        var bookAuthorArray = arrayOf(
            "Paulo Coelho",
            "James Clear",
            "Colleen Hoover",
            "Khaled Hosseini",
            "J.R.R. Tolkien",
            "Harper Lee",
            "Robert Kiyosaki",
            "Anne Frank"
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        bookList= arrayListOf<books>()

        for (index in bookImageArray.indices){
            val book = books(bookImageArray[index],bookTitleArray[index] ,bookAuthorArray[index])
            bookList.add(book)
        }

        val spanCount = if (resources.configuration.screenWidthDp < 600) 2 else 3
        myRecyclerView.layoutManager = GridLayoutManager(this, spanCount)
        myRecyclerView.adapter = MyAdapter(bookList,this)
    }
}