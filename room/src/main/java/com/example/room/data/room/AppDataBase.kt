package com.example.room.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.data.room.dao.NotificationDao
import com.example.room.data.room.entity.NotificationEntity

@Database(entities = [NotificationEntity::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun notificationDao(): NotificationDao
}