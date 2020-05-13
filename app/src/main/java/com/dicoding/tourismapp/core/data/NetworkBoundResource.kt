package com.dicoding.tourismapp.core.data

import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse

import com.dicoding.tourismapp.core.utils.AppExecutors
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    //    private val result = MediatorLiveData<Resource<ResultType>>()
    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB()
        if (shouldFetch(dbSource.first())) {
            fetchFromNetwork(dbSource)
        } else {
            emitAll(loadFromDB().map { Resource.Success(it) })
        }

    }

//    init {
//        result.value = Resource.Loading(null)
//
//        @Suppress("LeakingThis")
//        val dbSource = loadFromDB()
//
//        result.addSource(dbSource) { data ->
//            result.removeSource(dbSource)
//            if (shouldFetch(data)) {
//                fetchFromNetwork(dbSource)
//            } else {
//                result.addSource(dbSource) { newData ->
//                    result.value = Resource.Success(newData)
//                }
//            }
//        }
//    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private suspend fun fetchFromNetwork(dbSource: Flow<ResultType>) {

        val apiResponse = createCall().first()
        flow {
            emit(Resource.Loading())
            when (apiResponse) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emitAll(dbSource.map { Resource.Error(apiResponse.errorMessage, it) })
                }
            }
        }

//        result.addSource(dbSource) { newData ->
//            result.value = Resource.Loading(newData)
//        }
//        result.addSource(apiResponse) { response ->
//            result.removeSource(apiResponse)
//            result.removeSource(dbSource)
//            when (response) {
//                is ApiResponse.Success ->
//                    mExecutors.diskIO().execute {
//                        saveCallResult(response.data)
//                        mExecutors.mainThread().execute {
//                            result.addSource(loadFromDB()) { newData ->
//                                result.value = Resource.Success(newData)
//                            }
//                        }
//                    }
//                is ApiResponse.Empty -> mExecutors.mainThread().execute {
//                    result.addSource(loadFromDB()) { newData ->
//                        result.value = Resource.Success(newData)
//                    }
//                }
//                is ApiResponse.Error -> {
//                    onFetchFailed()
//                    result.addSource(dbSource) { newData ->
//                        result.value = Resource.Error(response.errorMessage, newData)
//                    }
//                }
//            }
//        }
    }

    fun asFlow(): Flow<Resource<ResultType>> = result
}