package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderLoadingBinding
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

class ProductLoadingViewHolder(
    private val binding: ViewHolderLoadingBinding,
): BaseViewHolder<ProductModel>(binding.root) {

    override fun bind(item: ProductModel) {
        with(item) {
            with(binding) {

            }
        }
    }
}