package com.dicoding.tourismapp.core.domain

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract fun run(params: Params): Type

    operator fun invoke(params: Params, onResult: (Type) -> Unit = {}) {
        onResult(run(params))
    }

    class None
}