package com.kangyasin.starter.kotlin.clean.data.source

import io.reactivex.Completable
import io.reactivex.Single
import com.kangyasin.starter.kotlin.clean.data.model.BufferooEntity
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooDataStore
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class BufferooRemoteDataStore @Inject constructor(private val bufferooRemote: BufferooRemote) :
        BufferooDataStore {

    override fun clearBufferoos(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooRemote.getBufferoos()
    }

}