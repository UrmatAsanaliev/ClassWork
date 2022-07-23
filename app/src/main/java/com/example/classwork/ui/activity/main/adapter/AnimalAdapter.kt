package com.example.classwork.ui.activity.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork.databinding.ItemAnimalBinding


class AnimalAdapter(private val click: OnClick):
    RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    private var list = arrayListOf<Int>()

    @SuppressLint("NotifyDataSetChanged")
    fun addAnimal(list: ArrayList<Int>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            holder.binding.imgAnimal.alpha = 0.3F
            click.click(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(names: Int) = with(binding) {
            imgAnimal.setImageResource(names)
        }
    }
    interface OnClick {
        fun click(pos: Int)
    }
}
