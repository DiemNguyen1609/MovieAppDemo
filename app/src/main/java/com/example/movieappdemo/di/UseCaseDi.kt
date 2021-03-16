package com.example.movieappdemo.di

import com.example.domain.usecases.DiscoverUseCase
import com.example.movieappdemo.common.AsyncFlowableTransformer
import org.koin.dsl.module.module

val mUseCaseModules = module {
    factory(name = "disvoer_usecase"){ DiscoverUseCase(transformer = AsyncFlowableTransformer(),repositories = get()) }
}