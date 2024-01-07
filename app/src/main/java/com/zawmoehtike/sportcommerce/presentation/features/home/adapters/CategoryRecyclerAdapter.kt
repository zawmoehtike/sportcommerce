package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.view.ViewGroup
import com.zawmoehtike.sportcommerce.appbase.core.extension.inflater
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseListAdapter
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.sportcommerce.databinding.ViewHolderCategoryBinding
import com.zawmoehtike.sportcommerce.presentation.viewdata.CategoryViewData

class CategoryRecyclerAdapter(private val onClick : (CategoryViewData) -> Unit):
    BaseListAdapter<CategoryViewData, BaseViewHolder<CategoryViewData>>(diffCallback = diffCallBackWith(
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        },
        areItemTheSame = { item1, item2 ->
            item1 == item2
        }
    )) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CategoryViewData> {
        val inflater = parent.context.inflater()

        val view = ViewHolderCategoryBinding.inflate(inflater, parent, false)

        return CategoryViewHolder(view, ::refreshSelectState)
    }

    fun refreshSelectState(item: CategoryViewData) {
        currentList.forEach {
            it.isSelected = it.id == item.id
        }

        notifyDataSetChanged()
    }
}