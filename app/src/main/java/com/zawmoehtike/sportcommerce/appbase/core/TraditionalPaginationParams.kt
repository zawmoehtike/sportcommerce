package com.zawmoehtike.sportcommerce.appbase.core

data class TraditionalPaginationParams(
    var isLoading: Boolean = false,
    var currentPage: Long = 1L,
    var isPageEnded: Boolean = false
) {
    fun resetValues() {
        isLoading = false
        currentPage = 1
        isPageEnded = false
    }

    fun isFirstPage(): Boolean {
        return currentPage == 1L
    }
}