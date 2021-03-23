package com.example.movieappdemo.home.di

import com.example.movieappdemo.home.HomeViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}