package com.zawmoehtike.sportcommerce.network.home.service

import com.zawmoehtike.sportcommerce.network.config.DataResponse
import com.zawmoehtike.sportcommerce.network.home.response.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @GET("6060200a-cfa2-4ef7-acfd-b93fa541fdd3")
    suspend fun getProductList(): Response<DataResponse<List<ProductResponse>>>

    @GET("6060200a-cfa2-4ef7-acfd-b93fa541fdd3")
    suspend fun getProductDetails(id: String): Response<DataResponse<ProductResponse>>
}