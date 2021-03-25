package com.kangyasin.starter.kotlin.clean.presentation.browse

import com.kangyasin.starter.kotlin.clean.presentation.BasePresenter
import com.kangyasin.starter.kotlin.clean.presentation.BaseView
import com.kangyasin.starter.kotlin.clean.presentation.model.BufferooView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseBufferoosContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showBufferoos(bufferoos: List<BufferooView>)

        fun hideBufferoos()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveBufferoos()

    }

}