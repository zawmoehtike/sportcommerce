package com.zawmoehtike.sportcommerce.appbase.di

import com.zawmoehtike.sportcommerce.domain.DefaultDispatcherProvider
import com.zawmoehtike.sportcommerce.domain.DispatcherProvider
import com.zawmoehtike.sportcommerce.appbase.exception.ExceptionToStringMapper
import com.zawmoehtike.sportcommerce.appbase.exception.ExceptionToStringMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    @Binds
    abstract fun dispatcherProvider(dispatcherProvider: DefaultDispatcherProvider): DispatcherProvider

    @Binds
    @Singleton
    abstract fun exceptionToStringMapper(exceptionToStringMapperImpl: ExceptionToStringMapperImpl): ExceptionToStringMapper
}
