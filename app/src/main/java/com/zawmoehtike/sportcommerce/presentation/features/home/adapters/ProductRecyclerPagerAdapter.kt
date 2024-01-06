package com.zawmoehtike.sportcommerce.presentation.features.home.adapters

import android.view.ViewGroup
import com.zawmoehtike.sportcommerce.appbase.core.extension.inflater
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseListAdapter
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.BaseViewHolder
import com.zawmoehtike.sportcommerce.appbase.core.recyclerview.diffCallBackWith
import com.zawmoehtike.sportcommerce.databinding.ViewHolderLoadingBinding
import com.zawmoehtike.sportcommerce.databinding.ViewHolderProductBinding
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

class ProductRecyclerPagerAdapter(private val onClick : (ProductModel) -> Unit):
    BaseListAdapter<ProductModel, BaseViewHolder<ProductModel>>(diffCallback = diffCallBackWith(
        areContentsTheSame = { item1, item2 ->
            item1 == item2
        },
        areItemTheSame = { item1, item2 ->
            item1 == item2
        }
    )) {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    private var isLoading = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ProductModel> {
        val inflater = parent.context.inflater()

        return if (viewType == VIEW_TYPE_ITEM) {
            val view = ViewHolderProductBinding.inflate(inflater, parent, false)
            ProductViewHolder(view, onClick)
        } else {
            val view = ViewHolderLoadingBinding.inflate(inflater, parent, false)
            ProductLoadingViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == (currentList.size - 1) && isLoading) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ITEM
        }
    }

    // Call this method to set loading state and trigger loading view visibility change
    fun setLoading(isLoading: Boolean) {
        this.isLoading = isLoading

        if(isLoading) {
            currentList.toMutableList().add(ProductModel())

            notifyDataSetChanged()
        } else {
            currentList.toMutableList().remove(ProductModel())

            notifyDataSetChanged()
        }
    }
}