package com.example.room.di

import com.example.room.data.useCase.notofication.NotificationUseCase
import com.example.room.data.useCase.notofication.NotificationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<NotificationUseCase> { NotificationUseCaseImpl(get()) }
}