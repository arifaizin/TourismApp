package com.dicoding.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.di.AppScope
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import javax.inject.Inject
import javax.inject.Singleton

@AppScope
class FavoriteViewModelFactory @Inject constructor(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

//    hapus kode berikut
//    companion object {
//        @Volatile
//        private var instance: FavoriteViewModelFactory? = null
//
//        fun getInstance(context: Context): FavoriteViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: FavoriteViewModelFactory(Injection.provideGetFavoriteTourismUseCase(context))
//            }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(getFavoriteTourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
