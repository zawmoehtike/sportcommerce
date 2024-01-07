package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.graphics.Color
import android.view.View
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderColorBinding
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

class ColorViewHolder(
    private val binding: ViewHolderColorBinding,
    private val onClick: (ProductModel.ColorValue) -> Unit,
): BaseViewHolder<ProductModel.ColorValue>(binding.root) {

    override fun bind(item: ProductModel.ColorValue) {
        with(item) {
            with(binding) {
                view.setBackgroundColor(Color.parseColor("#${value}"))

                if(isSelected) {
                    ivMark.visibility = View.VISIBLE
                } else {
                    ivMark.visibility = View.GONE
                }

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}