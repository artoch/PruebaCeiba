package com.tochapps.ceibatestapp.di.data

import com.tochapps.ceibatestapp.data.local.dao.user.UserDao
import com.tochapps.ceibatestapp.data.local.repository.user.UserCacheRepository
import com.tochapps.ceibatestapp.data.local.repository.user.UserCacheRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RepositoryCacheModule {
    @Singleton
    @Provides
    fun provideTestRepository(
        dao: UserDao
    ): UserCacheRepository = UserCacheRepositoryImpl(
        dao
    )
}