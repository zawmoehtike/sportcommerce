package com.zawmoehtike.sportcommerce.appbase.exception

interface UnidirectionalMap<F, T> {
    fun map(item: F?): T
}