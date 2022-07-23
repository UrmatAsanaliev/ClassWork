package com.example.classwork.ui.activity.second.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork.databinding.ItemResultBinding

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    private var list = arrayListOf<Int>()

    @SuppressLint("NotifyDataSetChanged")
    fun addResult(list: ArrayList<Int>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(names: Int) {
            binding.imgResult.setImageResource(names)
        }
    }
}