package com.dicoding.tourismapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApplication : Application() {

//    private val coreComponent: CoreComponent by lazy {
//        DaggerCoreComponent.factory().create(applicationContext)
//    }
//
//    val appComponent: AppComponent by lazy {
//        DaggerAppComponent.factory().create(coreComponent)
//    }
}

