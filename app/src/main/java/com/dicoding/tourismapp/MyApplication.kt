package com.dicoding.tourismapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.dicoding.tourismapp.core.di.AppComponent
import com.dicoding.tourismapp.core.di.CoreComponent
import com.dicoding.tourismapp.core.di.DaggerCoreComponent

open class MyApplication : Application() {

//    val appComponent: AppComponent by lazy {
//        // Creates an instance of AppComponent using its Factory constructor
//        // We pass the applicationContext that will be used as Context in the graph
//        DaggerAppComponent.factory().create(applicationContext)
//    }
//
//    private val coreComponent: CoreComponent by lazy {
//        DaggerCoreComponent.factory().create(applicationContext, appComponent)
//    }
//
//    companion object {
//        fun coreComponent(context: Context) =
//            (context.applicationContext as MyApplication).coreComponent
//    }
}

//fun Activity.coreComponent() = MyApplication.coreComponent(this)