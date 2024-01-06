package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

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

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}