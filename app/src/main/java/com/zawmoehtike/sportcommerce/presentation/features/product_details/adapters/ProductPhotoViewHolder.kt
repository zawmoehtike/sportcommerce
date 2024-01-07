package com.zawmoehtike.sportcommerce.presentation.features.product_details.adapters

import com.zawmoehtike.sportcommerce.appbase.common.utils.GlideUtils.loadCenterCropImageFromUrl
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.databinding.ViewHolderProductPhotoBinding

class ProductPhotoViewHolder(
    private val binding: ViewHolderProductPhotoBinding,
    private val onClick: (String) -> Unit,
): BaseViewHolder<String>(binding.root) {

    override fun bind(item: String) {
        with(item) {
            with(binding) {
                ivPhoto.loadCenterCropImageFromUrl(item)

                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}