package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderCategoryBinding
import com.zawmoehtike.sportcommerce.presentation.viewdata.CategoryViewData

class CategoryViewHolder(
    private val binding: ViewHolderCategoryBinding,
    private val onClick: (CategoryViewData) -> Unit,
): BaseViewHolder<CategoryViewData>(binding.root) {

    override fun bind(item: CategoryViewData) {
        with(item) {
            with(binding) {
                ivBrand.setImageResource(image?:0)

                if(isSelected) {
                    ivBrand.alpha = 1F
                } else {
                    ivBrand.alpha = 0.25F
                }

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}