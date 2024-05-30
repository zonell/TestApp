package com.example.testapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ItemCategoriesBinding
import com.example.testapp.ui.view.categoriesItem.model.CategoriesItem

class CategoriesAdapter(
    val onItemClick: (CategoriesItem) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.ActivityVH>() {

    class ActivityVH(val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<CategoriesItem>() {
        override fun areItemsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem.isError == newItem.isError
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityVH {
        val binding = ItemCategoriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ActivityVH(
            binding
        )
    }

    override fun getItemCount() = list.currentList.size

    override fun onBindViewHolder(holder: ActivityVH, position: Int) {
        val item = list.currentList[position]
        holder.binding.apply {
            category.apply {
                setCategoryItem(item)
                setState(item.isError)
            }
            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}