package com.zawmoehtike.sportcommerce.data.home.repository_impl

import com.zawmoehtike.sportcommerce.data.home.mapper.ProductEntityMapper
import com.zawmoehtike.sportcommerce.data.home.networkdatasource.HomeNetworkDataSource
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel
import com.zawmoehtike.sportcommerce.domain.home.respository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val networkDataSource: HomeNetworkDataSource,
    private val productEntityMapper: ProductEntityMapper,
): HomeRepository {

    override suspend fun getProductList(currentPage: String): List<ProductModel> {
        val data = networkDataSource.getProductList(currentPage)
        val list = data.map {
            productEntityMapper.map(it)
        }
        return list
    }

    override suspend fun getProductDetails(id: String): ProductModel {
        val data = networkDataSource.getProductDetails(id)
        val product = productEntityMapper.map(data)
        return product
    }
}