package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailTourismViewModelFactory @Inject constructor(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

//    hapus kode berikut
//    companion object {
//        @Volatile
//        private var instance: DetailTourismViewModelFactory? = null
//
//        fun getInstance(context: Context): DetailTourismViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: DetailTourismViewModelFactory(Injection.provideSetFavoriteTourismUseCase(context))
//            }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(setFavoriteTourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
