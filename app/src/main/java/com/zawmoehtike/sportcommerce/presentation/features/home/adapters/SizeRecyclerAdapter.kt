package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.view.ViewGroup
import com.zawmoehtike.sportcommerce.appbase.core.extension.inflater
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseListAdapter
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.sportcommerce.databinding.ViewHolderSizeBinding
import com.zawmoehtike.sportcommerce.domain.home.model.SizeModel

class SizeRecyclerAdapter(private val onClick : (SizeModel.SizeValue) -> Unit):
    BaseListAdapter<SizeModel.SizeValue, BaseViewHolder<SizeModel.SizeValue>>(diffCallback = diffCallBackWith(
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        },
        areItemTheSame = { item1, item2 ->
            item1 == item2
        }
    )) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<SizeModel.SizeValue> {
        val inflater = parent.context.inflater()

        val view = ViewHolderSizeBinding.inflate(inflater, parent, false)

        return SizeViewHolder(view, ::refreshSelectState)
    }

    fun refreshSelectState(item: SizeModel.SizeValue) {
        currentList.forEach {
            it.isSelected = it.value == item.value
        }

        notifyDataSetChanged()
    }
}