package com.example.toast

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

private const val TURN_ON_COUNTER = "turnOnCounter"

class NewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val sp = getSharedPreferences(TURN_ON_COUNTER, Context.MODE_PRIVATE)
        val counter = sp.getInt("counter", 0)
        when {
            counter < 2 -> putIntSP(counter, sp)
            counter == 2 -> {
                Toast.makeText(applicationContext, "Какой то произвольный текст", Toast.LENGTH_SHORT)
                    .show()
                putIntSP(counter, sp)
            }
            else -> {

            }
        }
    }

    private fun putIntSP(count: Int, sp: SharedPreferences) {
        val count = count + 1
        val e: SharedPreferences.Editor = sp.edit()
        e.putInt("counter", count)
        e.apply()
    }
}