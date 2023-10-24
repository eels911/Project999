package com.example.project999

import android.app.Application
import android.util.Log

class App: Application() {

    private var localCache = ""
    private val handleDeath = HandleDeath.Base()

    override fun onCreate() {
        super.onCreate()
        val processId = android.os.Process.myPid()
        Log.d("sab","app onCreate $processId")
    }

    fun activityCreated(firstOpening: Boolean){
        if (firstOpening) {
            Log.d("sab","very firs time")
            handleDeath.firstOpening()
        } else {
            if (handleDeath.wasDeathHappened()) {
                Log.d("sab", "Death happened")
                handleDeath.deathHandled()
            } else {
                // use local cache and dont use permanent
                Log.d("sab", "just activity recreated")
            }
        }
    }

}