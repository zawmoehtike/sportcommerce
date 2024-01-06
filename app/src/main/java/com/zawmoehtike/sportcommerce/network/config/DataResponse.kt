package com.zawmoehtike.sportcommerce.network.config

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse<T>(
    @Json(name = "data") val data: T?,
    @Json(name = "error") val error: ErrorResponse?
)

@JsonClass(generateAdapter = true)
data class ErrorResponse (
    @Json(name = "status") val status: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "message") val message: Int?,
    @Json(name = "details") val details: Any?
)

@JsonClass(generateAdapter = true)
data class PageResponse<T>(
    @Json(name = "data") val data: List<T>?,
    @Json(name = "current_page") val currentPage: Int?,
    @Json(name = "per_page") val perPage: Int?,
    @Json(name = "total") val totalPage: Int
)