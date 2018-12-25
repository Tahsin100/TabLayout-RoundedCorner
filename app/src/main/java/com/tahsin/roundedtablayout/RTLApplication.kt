package com.tahsin.roundedtablayout

import android.app.Application

class RTLApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: RTLApplication
            private set
    }
}