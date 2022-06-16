package com.example.toast

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.SharedPreferences
import android.system.Os.remove
import android.text.method.TextKeyListener.clear
import android.widget.TextView
import java.lang.Exception
import kotlin.properties.Delegates


private const val TURN_ON_COUNTER = "turnOnCounter"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = getSharedPreferences(TURN_ON_COUNTER, Context.MODE_PRIVATE)
        val counter = sp.getInt("counter", 0)
        if (savedInstanceState == null && counter < 2)
            putIntSP(counter, sp)
        else if (savedInstanceState == null && counter == 2) {
            Toast.makeText(applicationContext, "Какой то произвольный текст", Toast.LENGTH_SHORT).show()
            putIntSP(counter, sp)
        } else {

        }
    }

    private fun putIntSP(count: Int, sp: SharedPreferences) {
        val count = count + 1
        val e: SharedPreferences.Editor = sp.edit()
        e.putInt("counter", count)
        e.apply()
    }
}