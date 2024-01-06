package com.zawmoehtike.sportcommerce.network.home.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "id")
    val id: String?,
    @Json(name = "color")
    val color: List<String>?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "rating")
    val rating: String?,
    @Json(name = "size")
    val size: SizeResponse?
)