package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.di.AppComponent
import com.dicoding.core.di.CoreComponent
import com.dicoding.core.di.DaggerCoreComponent
import com.dicoding.tourismapp.di.DaggerAppComponent
import com.mapbox.mapboxsdk.Mapbox

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_access_token))
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}

