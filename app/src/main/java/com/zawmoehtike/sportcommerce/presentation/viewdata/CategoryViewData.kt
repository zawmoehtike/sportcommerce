package com.zawmoehtike.sportcommerce.presentation.viewdata

import com.zawmoehtike.sportcommerce.R

data class CategoryViewData(
    val id: String? = null,
    var image: Int? = null,
    var name: String? = null,
    var isSelected: Boolean = false
) {
    fun getCategoryVDList(): List<CategoryViewData> {
        return listOf(
            CategoryViewData(
                id = "1",
                image = R.drawable.ic_addidas,
                name = "Addidas"
            ),
            CategoryViewData(
                id = "2",
                image = R.drawable.ic_nike,
                name = "Nike"
            ),
            CategoryViewData(
                id = "3",
                image = R.drawable.ic_puma,
                name = "Puma"
            ),
            CategoryViewData(
                id = "4",
                image = R.drawable.ic_tesla,
                name = "Tesla"
            ),
            CategoryViewData(
                id = "5",
                image = R.drawable.ic_google,
                name = "Google"
            ),
            CategoryViewData(
                id = "6",
                image = R.drawable.ic_twitter,
                name = "Twitter"
            )
        )
    }
}