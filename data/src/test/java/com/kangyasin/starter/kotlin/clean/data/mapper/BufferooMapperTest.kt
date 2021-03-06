package com.kangyasin.starter.kotlin.clean.data.mapper

import com.kangyasin.starter.kotlin.clean.data.model.BufferooEntity
import com.kangyasin.starter.kotlin.clean.data.test.factory.BufferooFactory
import com.kangyasin.starter.kotlin.clean.domain.model.Bufferoo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class BufferooMapperTest {

    private lateinit var bufferooMapper: BufferooMapper

    @Before
    fun setUp() {
        bufferooMapper = BufferooMapper()
    }

    @Test
    fun mapFromEntityMapsData() {
        val bufferooEntity = BufferooFactory.makeBufferooEntity()
        val bufferoo = bufferooMapper.mapFromEntity(bufferooEntity)

        assertBufferooDataEquality(bufferooEntity, bufferoo)
    }

    @Test
    fun mapToEntityMapsData() {
        val cachedBufferoo = BufferooFactory.makeBufferoo()
        val bufferooEntity = bufferooMapper.mapToEntity(cachedBufferoo)

        assertBufferooDataEquality(bufferooEntity, cachedBufferoo)
    }

    private fun assertBufferooDataEquality(bufferooEntity: BufferooEntity,
                                           bufferoo: Bufferoo) {
        assertEquals(bufferooEntity.name, bufferoo.name)
        assertEquals(bufferooEntity.title, bufferoo.title)
        assertEquals(bufferooEntity.avatar, bufferoo.avatar)
    }

}