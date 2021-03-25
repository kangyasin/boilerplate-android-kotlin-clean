package com.kangyasin.starter.kotlin.clean.ui.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.kangyasin.starter.kotlin.clean.domain.executor.PostExecutionThread
import com.kangyasin.starter.kotlin.clean.domain.repository.BufferooRepository
import com.kangyasin.starter.kotlin.clean.ui.injection.ApplicationComponent
import com.kangyasin.starter.kotlin.clean.ui.injection.module.ActivityBindingModule
import com.kangyasin.starter.kotlin.clean.ui.injection.module.TestApplicationModule
import com.kangyasin.starter.kotlin.clean.ui.injection.scopes.PerApplication
import com.kangyasin.starter.kotlin.clean.ui.test.TestApplication

@Component(modules = arrayOf(TestApplicationModule::class, ActivityBindingModule::class,
        AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

    fun bufferooRepository(): BufferooRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

}