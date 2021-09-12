package com.example.androidtask.modules.details.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidtask.R
import com.example.androidtask.databinding.IsbnItemBinding
import com.example.androidtask.commons.di.scopes.DetailsScope
import com.example.androidtask.modules.details.presentation.model.IsbnModel
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DetailsScope
class IsbnListAdapter @Inject constructor() : ListAdapter<IsbnModel, RecyclerView.ViewHolder>(IsbnDiffUtil()){

    class IsbnDiffUtil : DiffUtil.ItemCallback<IsbnModel>() {
        override fun areItemsTheSame(oldItem: IsbnModel, newItem: IsbnModel): Boolean {
            return oldItem === newItem

        }

        override fun areContentsTheSame(oldItem: IsbnModel, newItem: IsbnModel): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return IsbnViewHolder(
            IsbnItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? IsbnViewHolder)?.bind(getItem(position))
    }

    inner class IsbnViewHolder (private val binding: IsbnItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: IsbnModel?) {
            binding.apply {
                item?.isbn?.let {isbn ->
                    isbnTv.text = isbn
                }
                item?.isbnCover?.let {cover ->
                    Glide.with(root.context).load(cover).placeholder(R.drawable.placeholder).into(isbnCoverIv)
                }
            }
        }
    }
}