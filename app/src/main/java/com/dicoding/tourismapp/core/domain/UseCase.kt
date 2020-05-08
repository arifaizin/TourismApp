package com.dicoding.tourismapp.core.domain

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract fun run(params: Params): Any

    operator fun invoke(params: Params, onResult: (Any) -> Unit = {}) {
        onResult(run(params))
    }

    class None
}