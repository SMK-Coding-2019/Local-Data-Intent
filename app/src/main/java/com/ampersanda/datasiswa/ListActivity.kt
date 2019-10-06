package com.ampersanda.datasiswa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    var recyclerViewList: List<Siswa> = ArrayList()

    var appDatabase: AppDatabase? = null
    var siswaDAO: SiswaDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        adapter = RecyclerAdapter(this, recyclerViewList)

        recyclerView.adapter = adapter

        // TODO : init database
        appDatabase = AppDatabase.getAppDatabase(this)
        siswaDAO = appDatabase?.SiswaDAO()

        siswaDAO?.ambilSemuaDataSiswa()?.observe(this, Observer {
            if (it.isEmpty()) {
                Toast.makeText(this, "Belum punya siswa", Toast.LENGTH_SHORT).show()
            }

            updateData(it)
        })

        fab.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            // TODO : suruh pak pos pergi dan ambil hasil
//            startActivityForResult(intent, 13)
        }
    }

    override fun onResume() {
        super.onResume()
        appDatabase = AppDatabase.getAppDatabase(this)
        siswaDAO = appDatabase?.SiswaDAO()

        siswaDAO?.ambilSemuaDataSiswa()?.observe(this, Observer {
            if (it.isEmpty()) {
                Toast.makeText(this, "Belum punya siswa", Toast.LENGTH_SHORT).show()
            }

            updateData(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        AppDatabase.hapusDatabase()
    }

    fun updateData(siswaSiswaBaru : List<Siswa>) {
        recyclerViewList = siswaSiswaBaru

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        adapter = RecyclerAdapter(this, recyclerViewList)

        recyclerView.adapter = adapter
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 13 && resultCode == 13) {
//            recyclerViewList.add((data!!.extras["siswa"] as Siswa))
//
//            adapter.notifyDataSetChanged()
//        }
//    }
}
