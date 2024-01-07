package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import com.zawmoehtike.sportcommerce.R
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderSizeBinding
import com.zawmoehtike.sportcommerce.domain.home.model.SizeModel

class SizeViewHolder(
    private val binding: ViewHolderSizeBinding,
    private val onClick: (SizeModel.SizeValue) -> Unit,
): BaseViewHolder<SizeModel.SizeValue>(binding.root) {

    override fun bind(item: SizeModel.SizeValue) {
        with(item) {
            with(binding) {
                tvSize.text = value

                if(isSelected) {
                    tvSize.setTextColor(binding.root.context.getColor(R.color.white))
                    view.setBackgroundColor(binding.root.context.getColor(R.color.color_new_orange))
                } else {
                    tvSize.setTextColor(binding.root.context.getColor(R.color.black))
                    view.setBackgroundColor(binding.root.context.getColor(R.color.color_white_grey))
                }

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}