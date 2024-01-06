package com.zawmoehtike.sportcommerce.domain.home.model

data class ProductModel(
    val id: String? = null,
    val color: List<String>? = null,
    val currency: String? = null,
    val description: String? = null,
    val image: String? = null,
    val name: String? = null,
    val price: String? = null,
    val rating: String? = null,
    val size: SizeModel? = null
)
