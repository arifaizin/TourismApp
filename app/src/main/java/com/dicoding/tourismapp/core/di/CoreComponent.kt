package com.dicoding.tourismapp.core.di

import android.content.Context
import com.dicoding.tourismapp.detail.DetailTourismActivity
import com.dicoding.tourismapp.favorite.FavoriteFragment
import com.dicoding.tourismapp.home.HomeFragment
import dagger.BindsInstance
import dagger.Component

@CoreScope
@Component(
    modules = [DatabaseModule::class, NetworkModule::class, RepositoryModule::class],
    dependencies = [AppComponent::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, appComponent: AppComponent): CoreComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}