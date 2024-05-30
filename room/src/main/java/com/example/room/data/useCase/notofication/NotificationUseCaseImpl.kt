package com.example.room.data.useCase.notofication

import com.example.room.data.repository.notification.NotificationRepository
import com.example.room.data.room.entity.NotificationEntity

class NotificationUseCaseImpl(
    private val repository: NotificationRepository
) : NotificationUseCase {

    override suspend fun addNotification(notification: NotificationEntity) {
        return repository.insert(notification)
    }

    override suspend fun insert(notifications: List<NotificationEntity>) {
        return repository.insert(notifications)
    }

    override suspend fun modifyNotification(notification: NotificationEntity) {
        repository.update(notification)
    }

    override suspend fun removeNotification(notification: NotificationEntity) {
        repository.delete(notification)
    }

    override suspend fun getNotification(id: Int): NotificationEntity? {
        return repository.getById(id)
    }

    override suspend fun getAllNotifications(): List<NotificationEntity> {
        return repository.getAll()
    }

    override suspend fun clearAllNotifications() {
        repository.deleteAll()
    }
}
