package com.example.toast

import android.app.Application
import android.util.Log

class NewApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("Log","start")
    }
}