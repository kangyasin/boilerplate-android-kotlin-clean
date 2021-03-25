package com.kangyasin.starter.kotlin.clean.ui.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.kangyasin.starter.kotlin.clean.cache.BufferooCacheImpl
import com.kangyasin.starter.kotlin.clean.cache.PreferencesHelper
import com.kangyasin.starter.kotlin.clean.cache.db.DbOpenHelper
import com.kangyasin.starter.kotlin.clean.cache.mapper.BufferooEntityMapper
import com.kangyasin.starter.kotlin.clean.data.BufferooDataRepository
import com.kangyasin.starter.kotlin.clean.data.executor.JobExecutor
import com.kangyasin.starter.kotlin.clean.data.mapper.BufferooMapper
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooCache
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooRemote
import com.kangyasin.starter.kotlin.clean.data.source.BufferooDataStoreFactory
import com.kangyasin.starter.kotlin.clean.domain.executor.PostExecutionThread
import com.kangyasin.starter.kotlin.clean.domain.executor.ThreadExecutor
import com.kangyasin.starter.kotlin.clean.domain.repository.BufferooRepository
import com.kangyasin.starter.kotlin.clean.remote.BufferooRemoteImpl
import com.kangyasin.starter.kotlin.clean.remote.BufferooService
import com.kangyasin.starter.kotlin.clean.remote.BufferooServiceFactory
import com.kangyasin.starter.kotlin.clean.ui.BuildConfig
import com.kangyasin.starter.kotlin.clean.ui.UiThread
import com.kangyasin.starter.kotlin.clean.ui.injection.scopes.PerApplication

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.kangyasin.starter.kotlin.clean.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: com.kangyasin.starter.kotlin.clean.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
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
        return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }
}
