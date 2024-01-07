package com.zawmoehtike.sportcommerce.domain.home.model

data class SizeModel(
    val eu: List<SizeValue>?,
    val uk: List<SizeValue>?,
    val us: List<SizeValue>?
) {
    data class SizeValue(
        val value: String?,
        var isSelected: Boolean = false
    )
}