package com.kangyasin.starter.kotlin.clean.cache.db.mapper

import android.database.Cursor
import com.kangyasin.starter.kotlin.clean.cache.BuildConfig
import com.kangyasin.starter.kotlin.clean.cache.db.Db
import com.kangyasin.starter.kotlin.clean.cache.db.DbOpenHelper
import com.kangyasin.starter.kotlin.clean.cache.model.CachedBufferoo
import com.kangyasin.starter.kotlin.clean.cache.test.DefaultConfig
import com.kangyasin.starter.kotlin.clean.cache.test.factory.BufferooFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(DefaultConfig.EMULATE_SDK))
class BufferooMapperTest {

    private lateinit var bufferooMapper: BufferooMapper
    private val database = DbOpenHelper(RuntimeEnvironment.application).writableDatabase

    @Before
    fun setUp() {
        bufferooMapper = BufferooMapper()
    }

    @Test
    fun parseCursorMapsData() {
        val cachedBufferoo = BufferooFactory.makeCachedBufferoo()
        insertCachedBufferoo(cachedBufferoo)

        val cursor = retrieveCachedBufferooCursor()
        assertEquals(cachedBufferoo, bufferooMapper.parseCursor(cursor))
    }

    private fun retrieveCachedBufferooCursor(): Cursor {
        val cursor = database.rawQuery("SELECT * FROM " + Db.BufferooTable.TABLE_NAME, null)
        cursor.moveToFirst()
        return cursor
    }

    private fun insertCachedBufferoo(cachedBufferoo: CachedBufferoo) {
        database.insertOrThrow(Db.BufferooTable.TABLE_NAME, null,
                bufferooMapper.toContentValues(cachedBufferoo))
    }

}