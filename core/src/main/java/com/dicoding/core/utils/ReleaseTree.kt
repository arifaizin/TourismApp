package com.dicoding.core.utils

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN){
            //Send your report online, ex: to Firebase Crashlytics
        }
    }
}