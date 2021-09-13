package com.tochapps.ceibatestapp.common.extension

import android.app.Activity
import android.content.Intent

//StartActivity
inline fun <reified T: Activity> Activity.goToActivity(noinline init: Intent.() -> Unit = {}){
    val intent = Intent(this,T::class.java)
    intent.init()
    startActivity(intent)
}