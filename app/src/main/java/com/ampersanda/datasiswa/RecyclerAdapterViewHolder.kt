package com.ampersanda.datasiswa

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.item_name)
    val gender = itemView.findViewById<TextView>(R.id.item_gender)
    val email = itemView.findViewById<TextView>(R.id.item_email)
}