package com.route.islamic38sat.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic38sat.databinding.ItemHadethBinding
import com.route.islamic38sat.ui.model.Hadeth

class HadethRecyclerAdapter(private var items: List<Hadeth>?) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text = items!![position].title
        if (onItemClickListener != null) {
            holder.viewBinding.root
                .setOnClickListener {
                    onItemClickListener?.onItemClick(position, items!![position])
                }
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    fun bindItems(newList: List<Hadeth>) {
        items = newList
        notifyDataSetChanged()
    }

    //    fun insertItem(hadeth:Hadeth){
//        items?.add(hadeth)
//        notifyItemInserted((items?.size-1)?:0)
//    }
    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, item: Hadeth)
    }

    class ViewHolder(val viewBinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}