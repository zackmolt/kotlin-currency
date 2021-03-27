package com.jonathandarwin.currency.base.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonathandarwin.currency.databinding.ListBottomSheetBinding
import com.jonathandarwin.currency.databinding.ListBottomSheetItemBinding

/**
 * Created By : Jonathan Darwin on March 27, 2021
 */ 
class ListBottomSheetAdapter : RecyclerView.Adapter<ListBottomSheetAdapter.ListBottomSheetViewHolder>() {

    private val list = arrayListOf<ListBottomSheet>()
    private var listener: ((ListBottomSheet) -> Unit)? = null

    inner class ListBottomSheetViewHolder(private val binding: ListBottomSheetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListBottomSheet) {
            binding.tvLabel.text = item.label
            binding.root.setOnClickListener { listener?.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBottomSheetViewHolder =
        ListBottomSheetViewHolder(ListBottomSheetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListBottomSheetViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateData(newList: ArrayList<ListBottomSheet>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: (ListBottomSheet) -> Unit) {
        this.listener = listener
    }
}