package com.kangyasin.starter.kotlin.clean.remote

import io.reactivex.Single
import com.kangyasin.starter.kotlin.clean.data.model.BufferooEntity
import com.kangyasin.starter.kotlin.clean.data.repository.BufferooRemote
import com.kangyasin.starter.kotlin.clean.remote.mapper.BufferooEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BufferooRemoteImpl @Inject constructor(private val bufferooService: BufferooService,
                                             private val entityMapper: BufferooEntityMapper) :
        BufferooRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooService.getBufferoos()
                .map {
                    it.team.map { listItem ->
                        entityMapper.mapFromRemote(listItem)
                    }
                }
    }

}