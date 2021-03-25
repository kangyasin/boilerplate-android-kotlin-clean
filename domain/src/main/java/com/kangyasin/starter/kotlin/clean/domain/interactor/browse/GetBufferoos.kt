package com.kangyasin.starter.kotlin.clean.domain.interactor.browse

import io.reactivex.Single
import com.kangyasin.starter.kotlin.clean.domain.executor.PostExecutionThread
import com.kangyasin.starter.kotlin.clean.domain.executor.ThreadExecutor
import com.kangyasin.starter.kotlin.clean.domain.interactor.SingleUseCase
import com.kangyasin.starter.kotlin.clean.domain.model.Bufferoo
import com.kangyasin.starter.kotlin.clean.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}