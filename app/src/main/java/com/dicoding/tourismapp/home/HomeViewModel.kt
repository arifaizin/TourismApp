package com.dicoding.tourismapp.home

import androidx.lifecycle.*
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.GetAllTourismUseCase
import com.dicoding.tourismapp.core.domain.Tourism
import com.dicoding.tourismapp.core.domain.UseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getAllTourismUseCase: GetAllTourismUseCase) : ViewModel() {

    var tourism: MutableLiveData<Resource<List<Tourism>>> = MutableLiveData()

    fun getTourism() {
        getAllTourismUseCase(viewModelScope, UseCase.None()) {
            tourism.value = it.asLiveData().value
        }
    }
}

