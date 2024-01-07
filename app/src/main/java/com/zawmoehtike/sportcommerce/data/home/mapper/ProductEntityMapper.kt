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
            color = item?.color?.map {
                ProductModel.ColorValue(
                    value = it
                )
            },
            currency = item?.currency,
            description = item?.description,
            image = item?.image,
            name = item?.name,
            price = item?.price,
            rating = item?.rating,
            size = SizeModel(
                eu = item?.size?.eu?.map {
                    SizeModel.SizeValue(
                        value = it
                    )
                },
                uk = item?.size?.uk?.map {
                    SizeModel.SizeValue(
                        value = it
                    )
                },
                us = item?.size?.us?.map {
                    SizeModel.SizeValue(
                        value = it
                    )
                }
            )
        )
    }
}