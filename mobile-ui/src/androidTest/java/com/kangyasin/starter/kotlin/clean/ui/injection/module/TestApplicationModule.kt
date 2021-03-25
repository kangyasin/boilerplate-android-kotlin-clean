package com.kangyasin.starter.kotlin.clean.ui.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import com.kangyasin.starter.kotlin.clean.cache.PreferencesHelper
import com.kangyasin.starter.kotlin.clean.data.executor.JobExecutor
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooCache
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooRemote
import com.kangyasin.starter.kotlin.clean.domain.executor.PostExecutionThread
import com.kangyasin.starter.kotlin.clean.domain.executor.ThreadExecutor
import com.kangyasin.starter.kotlin.clean.domain.repository.BufferooRepository
import com.kangyasin.starter.kotlin.clean.remote.BufferooService
import com.kangyasin.starter.kotlin.clean.ui.UiThread
import com.kangyasin.starter.kotlin.clean.ui.injection.scopes.PerApplication

@Module
class TestApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): PreferencesHelper {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRepository(): BufferooRepository {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(): BufferooCache {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(): BufferooRemote {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService {
        return mock()
    }

}