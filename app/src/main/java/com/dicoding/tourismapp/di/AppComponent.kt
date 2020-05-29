package com.dicoding.tourismapp.di

import android.content.Context
import com.dicoding.tourismapp.core.di.CoreComponent
import com.dicoding.tourismapp.core.di.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component (modules = [SubcomponentsModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun coreComponent(): CoreComponent.Factory
}