package com.kangyasin.starter.kotlin.clean.data.repository

import io.reactivex.Single
import com.kangyasin.starter.kotlin.clean.data.model.BufferooEntity

/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface BufferooRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getBufferoos(): Single<List<BufferooEntity>>

}