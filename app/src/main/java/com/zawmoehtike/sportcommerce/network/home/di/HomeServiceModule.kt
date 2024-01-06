package com.zawmoehtike.sportcommerce.network.home.di

import com.zawmoehtike.sportcommerce.network.home.service.HomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object HomeServiceModule {
    @Provides
    fun provideHomeService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }
}