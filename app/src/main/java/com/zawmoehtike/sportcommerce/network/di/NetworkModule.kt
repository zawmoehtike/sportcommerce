package com.zawmoehtike.sportcommerce.network.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.squareup.moshi.Moshi
import com.zawmoehtike.sportcommerce.BuildConfig
import com.zawmoehtike.sportcommerce.network.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val CONNECT_TIMEOUT = 15L
    private const val READ_TIMEOUT = 60L
    private const val WRITE_TIMEOUT = 15L

    @Provides
    @Singleton
    fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggerInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggerInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return loggerInterceptor
    }

    @Provides
    @Singleton
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context
    ) : ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        loggerInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggerInterceptor)
            .addInterceptor(chuckerInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMoshiBuilder(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi).asLenient()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory): Retrofit {
        val baseUrl = BuildConfig.BASE_URL
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
    }
}