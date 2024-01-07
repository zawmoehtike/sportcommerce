package com.zawmoehtike.sportcommerce.network.home.datasource_impl

import com.zawmoehtike.sportcommerce.data.home.entity.ProductEntity
import com.zawmoehtike.sportcommerce.data.home.networkdatasource.HomeNetworkDataSource
import com.zawmoehtike.sportcommerce.network.getBodyOrThrowNetworkException
import com.zawmoehtike.sportcommerce.network.home.mapper.ProductSourceMapper
import com.zawmoehtike.sportcommerce.network.home.service.HomeService
import javax.inject.Inject

class HomeNetworkDataSourceImpl @Inject constructor(
    private val service: HomeService,
    private val productSourceMapper: ProductSourceMapper,
): HomeNetworkDataSource {

    override suspend fun getProductList(currentPage: String): List<ProductEntity> {
        val response = service.getProductList().getBodyOrThrowNetworkException()
        val list = response.data?.map {
            productSourceMapper.map(it)
        }
        return list?: emptyList()
    }

    override suspend fun getProductDetails(id: String): ProductEntity {
        val response = service.getProductDetails().getBodyOrThrowNetworkException()
        val product = productSourceMapper.map(response.data)
        return product
    }

}