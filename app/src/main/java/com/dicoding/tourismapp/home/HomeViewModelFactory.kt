package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val getAllTourismUseCase: GetAllTourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

//    companion object {
//        @Volatile
//        private var instance: HomeViewModelFactory? = null
//
//        fun getInstance(context: Context): HomeViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: HomeViewModelFactory(Injection.provideGetAllTourismUseCase(context))
//            }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(getAllTourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
