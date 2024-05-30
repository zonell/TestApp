package com.example.room.di

import androidx.room.Room
import com.example.room.data.room.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDataBase::class.java,
            "data_base.db"
        ).fallbackToDestructiveMigration().build()
    }
    single { get<AppDataBase>().notificationDao() }
}