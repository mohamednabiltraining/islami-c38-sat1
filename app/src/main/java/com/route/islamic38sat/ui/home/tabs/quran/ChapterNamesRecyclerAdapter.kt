package com.route.islamic38sat.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic38sat.databinding.ItemChapterNameBinding

class ChapterNamesRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<ChapterNamesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text = names[position]
        if (onItemClickListener != null) {
            holder.viewBinding.root
                .setOnClickListener {
                    onItemClickListener?.onItemClick(position, names[position])
                }
        }
    }

    override fun getItemCount(): Int = names.size

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }

    class ViewHolder(val viewBinding: ItemChapterNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}