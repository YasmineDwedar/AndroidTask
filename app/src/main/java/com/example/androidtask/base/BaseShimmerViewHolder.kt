package com.example.androidtask.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.R
import com.example.androidtask.utils.extensions.getColorInt
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

/**
 * Created by Yasmine on September,2021
 */
open class BaseShimmerViewHolder(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        (binding.root as? ShimmerFrameLayout)?.run {
            val builder = Shimmer.AlphaHighlightBuilder()
            builder.setAutoStart(true)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setShape(Shimmer.Shape.LINEAR)
                .setBaseAlpha(0.8f)
                .setHighlightAlpha(0f)
            val colorBuilder = Shimmer.ColorHighlightBuilder().copyFrom(builder.build())
                .setHighlightColor(R.color.lightBlack.getColorInt(context))
                .setBaseColor(R.color.cloudWhite.getColorInt(context))
            setShimmer(colorBuilder.build())
        }

    }
}