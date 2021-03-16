package com.example.movieappdemo

import android.app.Application
import com.example.movieappdemo.di.mLoginRepositoryModules
import com.example.movieappdemo.di.mNetworkModules
import com.example.movieappdemo.di.mUseCaseModules
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(
            this,
            listOf(
                mNetworkModules,
                mLoginRepositoryModules,
                mUseCaseModules
            )
        )
    }
}