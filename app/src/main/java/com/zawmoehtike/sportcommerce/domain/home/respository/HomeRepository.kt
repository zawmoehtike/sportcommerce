package com.zawmoehtike.sportcommerce.domain.home.respository

import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel

interface HomeRepository {
    suspend fun getProductList(currentPage: String): List<ProductModel>
    suspend fun getProductDetails(id: String): ProductModel
}