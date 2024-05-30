package com.example.testapp.aplication

import android.app.Application
import com.example.room.di.repositoryModule
import com.example.room.di.roomModule
import com.example.room.di.useCaseModule
import com.example.testapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            module {
                androidContext(this@App)
                modules(
                    listOf(
                        roomModule,
                        repositoryModule,
                        useCaseModule,
                        viewModelModule
                    )
                )
            }
        }
    }
}