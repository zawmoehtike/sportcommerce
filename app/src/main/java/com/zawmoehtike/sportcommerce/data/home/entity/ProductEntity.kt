package com.zawmoehtike.sportcommerce.data.home.entity

data class ProductEntity(
    val id: String?,
    val color: List<String>?,
    val currency: String?,
    val description: String?,
    val image: String?,
    val name: String?,
    val price: String?,
    val rating: String?,
    val size: SizeEntity?
)
