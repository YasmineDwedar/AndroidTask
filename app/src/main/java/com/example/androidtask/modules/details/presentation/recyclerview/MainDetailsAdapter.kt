package com.example.androidtask.modules.details.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.R
import com.example.androidtask.databinding.ItemDetailHeaderBinding
import com.example.androidtask.databinding.ItemIsbnListBinding
import com.example.androidtask.commons.di.scopes.DetailsScope
import com.example.androidtask.modules.details.presentation.model.BaseDetailsModel
import com.example.androidtask.modules.details.presentation.model.ISBNListModel
import com.example.androidtask.modules.details.presentation.model.TitleAuthorModel
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DetailsScope
class MainDetailsAdapter @Inject constructor(private val detailsMainCallBack: DetailsMainCallBack):ListAdapter<BaseDetailsModel, RecyclerView.ViewHolder>(DetailsDiffUtil()) {

    class DetailsDiffUtil : DiffUtil.ItemCallback<BaseDetailsModel>() {
        override fun areItemsTheSame(oldItem: BaseDetailsModel, newItem: BaseDetailsModel): Boolean {
            return oldItem === newItem

        }

        override fun areContentsTheSame(oldItem: BaseDetailsModel, newItem: BaseDetailsModel): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun getItemViewType(position: Int): Int {

        return when (getItem(position)) {
            is TitleAuthorModel -> R.layout.item_detail_header
            else -> R.layout.item_isbn_list
        }
    }

    override fun onBindViewHolder(holderHome: RecyclerView.ViewHolder, position: Int) {
        when(holderHome){
            is DetailHeaderViewHolder -> holderHome.bind(getItem(position) as? TitleAuthorModel)
            is IsbnListViewHolder -> holderHome.bind(getItem(position) as? ISBNListModel)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.item_detail_header -> {
                DetailHeaderViewHolder(
                    ItemDetailHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                IsbnListViewHolder(
                    ItemIsbnListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }


    inner class DetailHeaderViewHolder (private val binding: ItemDetailHeaderBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: TitleAuthorModel?) {
            binding.apply {
                item?.title?.let {title ->
                    titleTv.text = title
                }
                item?.author?.let {author ->
                    authorTv.text = author
                }
                titleTv.setOnClickListener { detailsMainCallBack.onTitleClicked(item) }
                authorTv.setOnClickListener { detailsMainCallBack.onAuthorClicked(item) }

            }
        }
    }

    inner class IsbnListViewHolder (private val binding: ItemIsbnListBinding) : RecyclerView.ViewHolder(binding.root){

        private var isbnAdapter = IsbnListAdapter()
        fun bind(item: ISBNListModel?) {
            binding.apply {
                isbnRV.adapter = isbnAdapter
                isbnAdapter.submitList(item?.isbns)
            }
        }
    }

    interface DetailsMainCallBack {
        fun onTitleClicked(item: TitleAuthorModel?)
        fun onAuthorClicked(item: TitleAuthorModel?)

    }
}
