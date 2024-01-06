package com.zawmoehtike.sportcommerce.network.home.di

import com.zawmoehtike.sportcommerce.data.home.networkdatasource.HomeNetworkDataSource
import com.zawmoehtike.sportcommerce.network.home.datasource_impl.HomeNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeNetworkDataSourceModule {
    @Binds
    abstract fun bindHomeNetworkDataSource(homeNetworkDataSourceImpl: HomeNetworkDataSourceImpl): HomeNetworkDataSource
}