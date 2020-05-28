package com.dicoding.tourismapp.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.domain.SetFavoriteTourismUseCase

class DetailTourismViewModelFactory private constructor(private val setFavoriteTourismUseCase: SetFavoriteTourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: DetailTourismViewModelFactory? = null

        fun getInstance(context: Context): DetailTourismViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: DetailTourismViewModelFactory(Injection.provideSetFavoriteTourismUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(setFavoriteTourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
