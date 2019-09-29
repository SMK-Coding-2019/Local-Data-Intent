package com.ampersanda.datasiswa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var context : Context, var list : List<Siswa>) : RecyclerView.Adapter<RecyclerAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterViewHolder {
        val itemView : View = LayoutInflater.from(context)
            .inflate(R.layout.list_item, parent, false)

        return RecyclerAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterViewHolder, position: Int) {
        holder.name.text = list[position].nama
        holder.gender.text = list[position].gender
        holder.email.text = list[position].email
    }

}