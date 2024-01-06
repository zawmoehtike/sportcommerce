package com.zawmoehtike.sportcommerce.domain.home.usecase

import com.zawmoehtike.sportcommerce.domain.CoroutineUseCase
import com.zawmoehtike.sportcommerce.domain.DispatcherProvider
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel
import com.zawmoehtike.sportcommerce.domain.home.respository.HomeRepository
import javax.inject.Inject

class GetProductDetails @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val homeRepository: HomeRepository
) : CoroutineUseCase<String, ProductModel>(dispatcherProvider) {
    override suspend fun provide(params: String): ProductModel {
        return homeRepository.getProductDetails(params)
    }
}