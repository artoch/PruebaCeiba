package com.tochapps.ceibatestapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application(){
    companion object {
        lateinit var appContext: Context
        //val sessionManager by lazy { SessionManager(appContext) }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}