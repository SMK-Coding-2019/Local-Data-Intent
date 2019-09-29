package com.ampersanda.datasiswa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    var recyclerViewList = mutableListOf<Siswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        adapter = RecyclerAdapter(this, recyclerViewList)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter

        fab.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

//            startActivity(intent)
            // TODO : suruh pak pos pergi dan ambil hasil
            startActivityForResult(intent, 13)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 13 && resultCode == 13) {
            // TODO : set data ke list
            recyclerViewList.add((data!!.extras["siswa"] as Siswa))

            // TODO : kasih tahu adapter
            adapter.notifyDataSetChanged()
        }
    }
}
