package com.kangyasin.starter.kotlin.clean.domain.usecase.bufferoo

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import com.kangyasin.starter.kotlin.clean.domain.executor.PostExecutionThread
import com.kangyasin.starter.kotlin.clean.domain.executor.ThreadExecutor
import com.kangyasin.starter.kotlin.clean.domain.interactor.browse.GetBufferoos
import com.kangyasin.starter.kotlin.clean.domain.model.Bufferoo
import com.kangyasin.starter.kotlin.clean.domain.repository.BufferooRepository
import com.kangyasin.starter.kotlin.clean.domain.test.factory.BufferooFactory
import org.junit.Before
import org.junit.Test

class GetBufferoosTest {

    private lateinit var getBufferoos: GetBufferoos

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockBufferooRepository: BufferooRepository

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockBufferooRepository = mock()
        getBufferoos = GetBufferoos(mockBufferooRepository, mockThreadExecutor,
                mockPostExecutionThread)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        getBufferoos.buildUseCaseObservable(null)
        verify(mockBufferooRepository).getBufferoos()
    }

    @Test
    fun buildUseCaseObservableCompletes() {
        stubBufferooRepositoryGetBufferoos(Single.just(BufferooFactory.makeBufferooList(2)))
        val testObserver = getBufferoos.buildUseCaseObservable(null).test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
        val bufferoos = BufferooFactory.makeBufferooList(2)
        stubBufferooRepositoryGetBufferoos(Single.just(bufferoos))
        val testObserver = getBufferoos.buildUseCaseObservable(null).test()
        testObserver.assertValue(bufferoos)
    }

    private fun stubBufferooRepositoryGetBufferoos(single: Single<List<Bufferoo>>) {
        whenever(mockBufferooRepository.getBufferoos())
                .thenReturn(single)
    }

}