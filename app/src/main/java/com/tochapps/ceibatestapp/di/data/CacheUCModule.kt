package com.tochapps.ceibatestapp.di.data

import com.tochapps.ceibatestapp.data.local.repository.user.UserCacheRepository
import com.tochapps.ceibatestapp.data.local.use_case.user.AddAllUserCacheUC
import com.tochapps.ceibatestapp.data.local.use_case.user.GetAllUserCacheUC
import com.tochapps.ceibatestapp.data.local.use_case.user.GetUserCacheUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object CacheUCModule {

    @Singleton
    @Provides
    fun provideGetAllUserCacheUseCase(
        dao: UserCacheRepository
    ): GetAllUserCacheUC = GetAllUserCacheUC(dao)

    @Singleton
    @Provides
    fun provideAddListUserCacheUseCase(
        dao: UserCacheRepository
    ): AddAllUserCacheUC = AddAllUserCacheUC(dao)

    @Singleton
    @Provides
    fun provideGetUserCacheUseCase(
        dao: UserCacheRepository
    ): GetUserCacheUC = GetUserCacheUC(dao)

}