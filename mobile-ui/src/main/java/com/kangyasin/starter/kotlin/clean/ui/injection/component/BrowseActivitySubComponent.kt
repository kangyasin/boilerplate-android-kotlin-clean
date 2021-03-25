package com.kangyasin.starter.kotlin.clean.ui.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.kangyasin.starter.kotlin.clean.ui.browse.BrowseActivity

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}