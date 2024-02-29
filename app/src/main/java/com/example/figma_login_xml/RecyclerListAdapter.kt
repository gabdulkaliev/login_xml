package com.example.figma_login_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerListAdapter(private val list: List<String>):
    RecyclerView.Adapter<RecyclerListAdapter.TitleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        return TitleViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_title, parent, false))
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.title.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class TitleViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.fullNameTextView)
    }

}