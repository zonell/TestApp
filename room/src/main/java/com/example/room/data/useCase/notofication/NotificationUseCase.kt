package com.example.room.data.useCase.notofication

import com.example.room.data.room.entity.NotificationEntity

interface NotificationUseCase {
    suspend fun addNotification(notification: NotificationEntity)
    suspend fun insert(notifications: List<NotificationEntity>)
    suspend fun modifyNotification(notification: NotificationEntity)
    suspend fun removeNotification(notification: NotificationEntity)
    suspend fun getNotification(id: Int): NotificationEntity?
    suspend fun getAllNotifications(): List<NotificationEntity>
    suspend fun clearAllNotifications()
}
