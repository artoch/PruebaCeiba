package com.tochapps.ceibatestapp.di.data

import com.tochapps.ceibatestapp.data.network.service.user.UserDataService
import com.tochapps.ceibatestapp.data.network.service.user.UserDataServiceImpl
import com.tochapps.ceibatestapp.di.KtorModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class )
object ServiceModule {

    @Singleton
    @Provides
    fun provideUserDataService(
        httpClient: HttpClient,
        @Named(KtorModule.BASE_URL_KEY) baseUrl: String,
    ): UserDataService = UserDataServiceImpl(
        httpClient = httpClient,
        baseUrl = baseUrl,
    )
}