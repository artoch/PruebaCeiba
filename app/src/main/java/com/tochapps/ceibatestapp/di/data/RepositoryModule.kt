package com.tochapps.ceibatestapp.di.data

import com.tochapps.ceibatestapp.data.network.repository.user.UserDataRepository
import com.tochapps.ceibatestapp.data.network.repository.user.UserDataRepositoryImpl
import com.tochapps.ceibatestapp.data.network.service.user.UserDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class )
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTestRepository(
        service: UserDataService
    ): UserDataRepository = UserDataRepositoryImpl(
        service
    )
}