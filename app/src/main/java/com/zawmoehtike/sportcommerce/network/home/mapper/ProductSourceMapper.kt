package com.zawmoehtike.sportcommerce.network.home.mapper

import com.zawmoehtike.sportcommerce.appbase.exception.UnidirectionalMap
import com.zawmoehtike.sportcommerce.data.home.entity.ProductEntity
import com.zawmoehtike.sportcommerce.data.home.entity.SizeEntity
import com.zawmoehtike.sportcommerce.network.home.response.ProductResponse
import javax.inject.Inject

class ProductSourceMapper @Inject constructor(): UnidirectionalMap<ProductResponse, ProductEntity> {
    override fun map(item: ProductResponse?): ProductEntity {
        return ProductEntity(
            id = item?.id,
            color = item?.color,
            currency = item?.currency,
            description = item?.description,
            image = item?.image,
            name = item?.name,
            price = item?.price,
            rating = item?.rating,
            size = SizeEntity(
                eu = item?.size?.eu,
                uk = item?.size?.uk,
                us = item?.size?.us,
            )
        )
    }
}