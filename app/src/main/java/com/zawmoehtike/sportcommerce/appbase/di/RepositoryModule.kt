package com.zawmoehtike.sportcommerce.appbase.di

import com.zawmoehtike.sportcommerce.data.home.repository_impl.HomeRepositoryImpl
import com.zawmoehtike.sportcommerce.domain.home.respository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}