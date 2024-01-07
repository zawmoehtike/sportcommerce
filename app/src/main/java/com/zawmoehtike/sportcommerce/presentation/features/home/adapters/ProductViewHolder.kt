package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.graphics.ColorFilter
import android.graphics.PorterDuff
import com.zawmoehtike.sportcommerce.R
import com.zawmoehtike.sportcommerce.appbase.common.utils.GlideUtils.loadCenterCropImageFromUrl
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderProductBinding
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

class ProductViewHolder(
    private val binding: ViewHolderProductBinding,
    private val onClick: (ProductModel) -> Unit,
): BaseViewHolder<ProductModel>(binding.root) {

    override fun bind(item: ProductModel) {
        with(item) {
            with(binding) {
                tvPrice.text = "$currency $price"
                tvTitle.text = "$name"
                ivProduct.loadCenterCropImageFromUrl("$image")

                if(isFavourite) {
                    ivLove.setImageResource(R.drawable.ic_loved)
                } else {
                    ivLove.setImageResource(R.drawable.ic_love)
                }

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}