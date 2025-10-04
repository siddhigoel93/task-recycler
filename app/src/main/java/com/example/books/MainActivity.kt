package com.example.books

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
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

        val bookGenre = arrayOf(
            "Genre: Philosophical Fiction",
            "Genre: Self-Help",
            "Genre: Romance",
            "Genre: Historical Fiction",
            "Genre: Fantasy",
            "Genre: Classic Literature",
            "Genre: Personal Finance",
            "Genre: Autobiography"
        )
        val about_book = arrayOf(
            "Description: Follows Santiago, a shepherd boy, on a journey to find treasure and discover his 'Personal Legend,' blending mysticism and wisdom.",
            "Description: Explains how small, consistent habits can lead to significant life changes, offering practical strategies to build good habits and break bad ones.",
            "Description: A story about love, domestic abuse, and difficult choices, exploring the complexity of relationships and personal strength.",
            "Description: Chronicles friendship, guilt, and redemption set in Afghanistan, following Amir and his journey back to confront his past.",
            "Description: Bilbo Baggins, a reluctant hobbit, joins a quest to reclaim treasure from the dragon Smaug, encountering magical creatures and adventures.",
            "Description: Set in the racially segregated American South, Scout Finch narrates as her father defends a Black man accused of a crime, exploring justice and morality.",
            "Description: Contrasts lessons from two father figures to teach financial literacy, mindset, and wealth-building strategies.",
            "Description: Diary of a Jewish girl hiding with her family during WWII, giving a personal perspective on fear, hope, and survival."
        )
        bookList= arrayListOf<books>()

        for (index in bookImageArray.indices){
            val book = books(bookImageArray[index],bookTitleArray[index] ,bookAuthorArray[index] , bookGenre[index],about_book[index])
            bookList.add(book)
        }

        val spanCount = when {
            resources.configuration.screenWidthDp < 600 -> 2
            resources.configuration.screenWidthDp < 900 -> 3
            else -> 4
        }
        myRecyclerView.layoutManager = GridLayoutManager(this, spanCount)
        val myAdapter = MyAdapter(bookList,this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setClicklListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int){
                val intent = Intent(this@MainActivity, detailActivity::class.java)
                intent.putExtra("image", bookImageArray[position])
                intent.putExtra("title", bookTitleArray[position])
                intent.putExtra("author", bookAuthorArray[position])
                intent.putExtra("genre", bookGenre[position])
                intent.putExtra("about", about_book[position])
                startActivity(intent)

            }
        })

    }
}