package com.zawmoehtike.sportcommerce.appbase.common.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndReachedListener(
    private val recyclerView: RecyclerView,
    private val onEndReached: () -> Unit
) : RecyclerView.OnScrollListener() {

    private val layoutManager = recyclerView.layoutManager as LinearLayoutManager

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val totalItemCount = layoutManager.itemCount
        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
        val lastCompletelyVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition()

        if (totalItemCount - 1 == lastVisibleItem && lastCompletelyVisibleItem == lastVisibleItem) {
            // End of the list is reached
            onEndReached()
        }
    }
}