package com.dicoding.tourismapp.favorite

import androidx.lifecycle.*
import com.dicoding.tourismapp.core.domain.GetFavoriteTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism
import com.dicoding.tourismapp.core.domain.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val getFavoriteTourismUseCase: GetFavoriteTourismUseCase) :
    ViewModel() {

    val favoriteTourism = MutableLiveData<List<Tourism>>()

//    fun getFavoriteTourism() {
//        getFavoriteTourismUseCase(viewModelScope, UseCase.None()) {
//            val tourism = it.asLiveData()
//            favoriteTourism.value = tourism.value
//        }
//
//    }

    fun getFavoriteTourism() = getFavoriteTourismUseCase.run(UseCase.None()).asLiveData()

}

