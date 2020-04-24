package com.dicoding.tourismapp.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.injection.Injection
import com.dicoding.tourismapp.detail.DetailTourismViewModel

class DetailTourismViewModelFactory private constructor(private val tourismRepository: TourismRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: DetailTourismViewModelFactory? = null

        fun getInstance(context: Context): DetailTourismViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: DetailTourismViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
