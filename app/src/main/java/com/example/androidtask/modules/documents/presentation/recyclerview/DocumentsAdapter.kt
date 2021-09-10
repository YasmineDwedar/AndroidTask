package com.example.androidtask.modules.documents.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.R
import com.example.androidtask.commons.presentation.BaseShimmerViewHolder
import com.example.androidtask.databinding.DocumentItemBinding
import com.example.androidtask.databinding.DocumentItemShimmerBinding
import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel
import com.example.androidtask.modules.documents.presentation.model.DocumentsShimmerModel
import com.example.androidtask.commons.presentation.extensions.makeGoneIf
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DocumentsScope
class DocumentsAdapter @Inject constructor(private val  documentsMainCallBack: DocumentsMainCallBack) :
    ListAdapter<BaseDocumentsModel, RecyclerView.ViewHolder>(DocumentsDiffUtil()) {

    class DocumentsDiffUtil : DiffUtil.ItemCallback<BaseDocumentsModel>() {
        override fun areItemsTheSame(
            oldItem: BaseDocumentsModel,
            newItem: BaseDocumentsModel
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: BaseDocumentsModel,
            newItem: BaseDocumentsModel
        ): Boolean {
            return oldItem.equals(newItem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.document_item_shimmer -> {
                DocumentsShimmerViewHolder(
                    DocumentItemShimmerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                DocumentsViewHolder(
                    DocumentItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }
    override fun getItemViewType(position: Int): Int {

        return   when(getItem(position)) {
            is DocumentsShimmerModel -> R.layout.document_item_shimmer
            else -> R.layout.document_item
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? DocumentsViewHolder)?.bind(getItem(position) as? DocumentPresentationModel)
    }


    inner class DocumentsViewHolder(private val binding: DocumentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DocumentPresentationModel?) {
            binding.apply {
                item?.let {
                    titleTv.text = root.resources.getString(R.string.title,it.title)
                    authorTv.text = root.resources.getString(R.string.author,it.author)
                    view.makeGoneIf(bindingAdapterPosition == currentList.size - 1)
                }
            }
        }
    }

    inner class DocumentsShimmerViewHolder(binding: DocumentItemShimmerBinding) :
        BaseShimmerViewHolder(binding)

    interface DocumentsMainCallBack {
        fun onItemClicked(item: DocumentPresentationModel)
    }
}