package com.example.room.di

import com.example.room.data.repository.notification.NotificationRepository
import com.example.room.data.repository.notification.NotificationRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NotificationRepository> { NotificationRepositoryImpl(get()) }
}