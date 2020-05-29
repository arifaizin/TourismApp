package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.di.CoreComponent
import com.dicoding.tourismapp.di.AppComponent
import com.dicoding.tourismapp.di.DaggerAppComponent

open class MyApplication : Application() {

    private val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }

    val coreComponent: CoreComponent by lazy {
        appComponent.coreComponent().create()
    }
}