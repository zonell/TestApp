package com.example.room.data.repository.notification

import com.example.room.data.room.entity.NotificationEntity

interface NotificationRepository {
    suspend fun insert(notification: NotificationEntity)
    suspend fun insert(notifications: List<NotificationEntity>)
    suspend fun update(notification: NotificationEntity)
    suspend fun delete(notification: NotificationEntity)
    suspend fun getById(id: Int): NotificationEntity?
    suspend fun getAll(): List<NotificationEntity>
    suspend fun deleteAll()
}
