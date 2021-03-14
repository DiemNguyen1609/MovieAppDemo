package com.example.movieappdemo.di

import com.example.api.MovieApi
import com.example.domain.repositores.MovieRepository
import com.example.movieappdemo.BuildConfig
import com.example.movieappdemo.MovieViewModel
import com.example.repository.MovieRemoteImpl
import com.example.repository.MovieRepositoryImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

private const val RETROFIT_INSTANCE = "Retrofit"
private const val API = "Api"

val mNetworkModules = module {
    single(name = RETROFIT_INSTANCE) { createNetworkClient(BuildConfig.BASE_URL) }
    single(name = API) { (get() as Retrofit).create(MovieApi::class.java) }
}

val mLoginRepositoryModules = module {
    single(name = "movie_remote") { MovieRemoteImpl(api = get(API)) }
    single { MovieRepositoryImpl(remote = get("movie_remote")) as MovieRepository }
    viewModel { MovieViewModel(get()) }
}