package com.kangyasin.starter.kotlin.clean.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.kangyasin.starter.kotlin.clean.ui.browse.BrowseActivity
import com.kangyasin.starter.kotlin.clean.ui.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}