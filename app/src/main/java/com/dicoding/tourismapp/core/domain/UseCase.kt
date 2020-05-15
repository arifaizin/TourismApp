package com.dicoding.tourismapp.core.domain

import io.reactivex.Flowable

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract fun run(params: Params): Flowable<List<Tourism>>

    operator fun invoke(params: Params, onResult: (Type) -> Unit = {}) {
        onResult(run(params))
    }

    class None
}