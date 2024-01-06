package com.zawmoehtike.sportcommerce.network.home.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SizeResponse(
    @Json(name = "eu")
    val eu: List<String>?,
    @Json(name = "uk")
    val uk: List<String>?,
    @Json(name = "us")
    val us: List<String>?
)