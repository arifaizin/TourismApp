package com.dicoding.tourismapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.detail.DetailTourismViewModel
import com.dicoding.tourismapp.favorite.FavoriteViewModel
import com.dicoding.tourismapp.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @com.dicoding.tourismapp.di.ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @com.dicoding.tourismapp.di.ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @com.dicoding.tourismapp.di.ViewModelKey(DetailTourismViewModel::class)
    abstract fun bindDetailTourismViewModel(viewModel: DetailTourismViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}