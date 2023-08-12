package com.route.islamic38sat.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic38sat.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.content.text =
            verses[position]
    }

    override fun getItemCount(): Int = verses.size

    class ViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root)
}