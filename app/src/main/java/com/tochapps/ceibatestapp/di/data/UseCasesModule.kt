package com.tochapps.ceibatestapp.di.data

import com.tochapps.ceibatestapp.data.network.repository.user.UserDataRepository
import com.tochapps.ceibatestapp.data.network.use_case.GetAllUserUC
import com.tochapps.ceibatestapp.data.network.use_case.GetPostUserUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object UseCasesModule {

    @Singleton
    @Provides
    fun provideGetUserDataUseCase(
        repository: UserDataRepository
    ): GetAllUserUC = GetAllUserUC(repository)

    @Singleton
    @Provides
    fun provideGetPostUserDataUseCase(
        repository: UserDataRepository
    ): GetPostUserUC = GetPostUserUC(repository)

}