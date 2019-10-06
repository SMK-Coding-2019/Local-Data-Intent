package com.ampersanda.datasiswa

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.item_name)
    val gender: TextView = itemView.findViewById(R.id.item_gender)
    val email: TextView = itemView.findViewById(R.id.item_email)
    val deleteButton: Button = itemView.findViewById(R.id.item_delete)
}