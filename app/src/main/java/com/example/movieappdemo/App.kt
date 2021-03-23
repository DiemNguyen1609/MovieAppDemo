package com.example.movieappdemo

import android.app.Application
import com.example.movieappdemo.di.mLoginRepositoryModules
import com.example.movieappdemo.di.mNetworkModules
import com.example.movieappdemo.di.mUseCaseModules
import com.example.movieappdemo.home.di.homeModule
import com.example.movieappdemo.search.di.searchModule
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
                mUseCaseModules,
                homeModule,
                searchModule
            )
        )
    }
}