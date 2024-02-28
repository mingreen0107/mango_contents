package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {

            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)

        }

        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/350600",
                "https://img.siksinhot.com/place/1460622895364757.png?w=307&h=300&c=Y",
                "밍글스"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/349263",
                "https://img.siksinhot.com/place/1462946564336361.png?w=307&h=300&c=Y",
                "미 피아체"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/481964",
                "https://img.siksinhot.com/place/1682566194010108.jpg?w=307&h=300&c=Y",
                "익스퀴진"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/6024",
                "https://img.siksinhot.com/place/1675991310559225.jpg?w=307&h=300&c=Y",
                "라미띠에"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/350600",
                "https://img.siksinhot.com/place/1460622895364757.png?w=307&h=300&c=Y",
                "밍글스"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/349263",
                "https://img.siksinhot.com/place/1462946564336361.png?w=307&h=300&c=Y",
                "미 피아체"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/481964",
                "https://img.siksinhot.com/place/1682566194010108.jpg?w=307&h=300&c=Y",
                "익스퀴진"
            )
        )
        items.add(
            ContentsModel(
                "https://www.siksinhot.com/P/6024",
                "https://img.siksinhot.com/place/1675991310559225.jpg?w=307&h=300&c=Y",
                "라미띠에"
            )
        )
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerview.adapter = rvAdapter

       rvAdapter.itemClick = object : RVAdapter.ItemClick {
           override fun onClick(view: View, position: Int) {

               val intent = Intent(baseContext, ViewActivity::class.java)
               intent.putExtra("url", items[position].url)
               intent.putExtra("title", items[position].titleText)
               intent.putExtra("imageUrl", items[position].imageUrl)
               startActivity(intent)
           }

       }

        recyclerview.layoutManager = GridLayoutManager(this, 2)

    }

}