package com.kangyasin.starter.kotlin.clean.ui.injection.module

import dagger.Module
import dagger.Provides
import com.kangyasin.starter.kotlin.clean.domain.interactor.browse.GetBufferoos
import com.kangyasin.starter.kotlin.clean.presentation.browse.BrowseBufferoosContract
import com.kangyasin.starter.kotlin.clean.presentation.browse.BrowseBufferoosPresenter
import com.kangyasin.starter.kotlin.clean.presentation.mapper.BufferooMapper
import com.kangyasin.starter.kotlin.clean.ui.browse.BrowseActivity
import com.kangyasin.starter.kotlin.clean.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
