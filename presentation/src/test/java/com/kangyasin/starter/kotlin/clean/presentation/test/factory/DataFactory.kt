package com.kangyasin.starter.kotlin.clean.presentation.test.factory

/**
 * Factory class for data instances
 */
class DataFactory {

    companion object Factory {

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }

    }

}