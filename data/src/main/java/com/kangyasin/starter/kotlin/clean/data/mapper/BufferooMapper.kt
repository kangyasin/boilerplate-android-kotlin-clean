package com.kangyasin.starter.kotlin.clean.data.mapper

import com.kangyasin.starter.kotlin.clean.data.model.BufferooEntity
import com.kangyasin.starter.kotlin.clean.domain.model.Bufferoo
import javax.inject.Inject


/**
 * Map a [BufferooEntity] to and from a [Bufferoo] instance when data is moving between
 * this later and the Domain layer
 */
open class BufferooMapper @Inject constructor(): Mapper<BufferooEntity, Bufferoo> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: BufferooEntity): Bufferoo {
        return Bufferoo(type.name, type.title, type.avatar)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Bufferoo): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }


}