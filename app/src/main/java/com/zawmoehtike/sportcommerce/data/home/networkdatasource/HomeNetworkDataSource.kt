package com.zawmoehtike.sportcommerce.data.home.networkdatasource

import com.zawmoehtike.sportcommerce.data.home.entity.ProductEntity

interface HomeNetworkDataSource {
    suspend fun getProductList(currentPage: String): List<ProductEntity>
    suspend fun getProductDetails(id: String): ProductEntity
}