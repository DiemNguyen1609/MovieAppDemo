package com.example.movieappdemo.search.di

import com.example.movieappdemo.search.SearchViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val searchModule = module {
    viewModel { SearchViewModel() }
}