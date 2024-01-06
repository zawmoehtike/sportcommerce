package com.zawmoehtike.sportcommerce.data.home.mapper

import com.zawmoehtike.sportcommerce.appbase.exception.UnidirectionalMap
import com.zawmoehtike.sportcommerce.data.home.entity.ProductEntity
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel
import com.zawmoehtike.sportcommerce.domain.home.model.SizeModel
import javax.inject.Inject

class ProductEntityMapper @Inject constructor(

): UnidirectionalMap<ProductEntity, ProductModel> {

    override fun map(item: ProductEntity?): ProductModel {
        return ProductModel(
            id = item?.id,
            color = item?.color,
            currency = item?.currency,
            description = item?.description,
            image = item?.image,
            name = item?.name,
            price = item?.price,
            rating = item?.rating,
            size = SizeModel(
                eu = item?.size?.eu,
                uk = item?.size?.uk,
                us = item?.size?.us,
            )
        )
    }
}