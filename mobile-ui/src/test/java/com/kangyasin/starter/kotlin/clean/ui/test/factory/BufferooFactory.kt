package com.kangyasin.starter.kotlin.clean.ui.test.factory

import com.kangyasin.starter.kotlin.clean.presentation.model.BufferooView
import com.kangyasin.starter.kotlin.clean.ui.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}