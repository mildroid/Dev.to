package com.mildroid.devto.di

import com.mildroid.devto.data.DevRepository
import com.mildroid.devto.data.remote.DevApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun devRepository(devApi: DevApi): DevRepository {
        return DevRepository(devApi)
    }

}