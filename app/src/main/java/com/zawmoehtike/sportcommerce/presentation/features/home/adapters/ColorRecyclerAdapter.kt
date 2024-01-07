package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.view.ViewGroup
import com.zawmoehtike.sportcommerce.appbase.core.extension.inflater
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseListAdapter
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.sportcommerce.databinding.ViewHolderColorBinding
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

class ColorRecyclerAdapter(private val onClick : (ProductModel.ColorValue) -> Unit):
    BaseListAdapter<ProductModel.ColorValue, BaseViewHolder<ProductModel.ColorValue>>(diffCallback = diffCallBackWith(
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        },
        areItemTheSame = { item1, item2 ->
            item1 == item2
        }
    )) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ProductModel.ColorValue> {
        val inflater = parent.context.inflater()

        val view = ViewHolderColorBinding.inflate(inflater, parent, false)

        return ColorViewHolder(view, ::refreshSelectState)
    }

    fun refreshSelectState(item: ProductModel.ColorValue) {
        currentList.forEach {
            it.isSelected = it.value == item.value
        }

        notifyDataSetChanged()
    }
}