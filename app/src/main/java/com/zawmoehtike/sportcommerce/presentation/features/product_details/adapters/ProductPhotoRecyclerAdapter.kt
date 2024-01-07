package com.zawmoehtike.sportcommerce.presentation.features.product_details.adapters

import android.view.ViewGroup
import com.zawmoehtike.sportcommerce.appbase.core.extension.inflater
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseListAdapter
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.sportcommerce.databinding.ViewHolderProductPhotoBinding

class ProductPhotoRecyclerAdapter(private val onClick : (String) -> Unit):
    BaseListAdapter<String, BaseViewHolder<String>>(diffCallback = diffCallBackWith(
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        },
        areItemTheSame = { item1, item2 ->
            item1 == item2
        }
    )) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val inflater = parent.context.inflater()

        val view = ViewHolderProductPhotoBinding.inflate(inflater, parent, false)

        return ProductPhotoViewHolder(view, onClick)
    }
}