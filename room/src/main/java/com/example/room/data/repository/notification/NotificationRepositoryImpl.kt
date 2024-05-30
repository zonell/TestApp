package com.example.room.data.repository.notification

import com.example.room.data.room.dao.NotificationDao
import com.example.room.data.room.entity.NotificationEntity

class NotificationRepositoryImpl(
    private val notificationDao: NotificationDao
) : NotificationRepository {

    override suspend fun insert(notification: NotificationEntity){
        return notificationDao.insert(notification)
    }

    override suspend fun insert(notifications: List<NotificationEntity>) {
        return notificationDao.insert(notifications)
    }

    override suspend fun update(notification: NotificationEntity) {
        notificationDao.update(notification)
    }

    override suspend fun delete(notification: NotificationEntity) {
        notificationDao.delete(notification)
    }

    override suspend fun getById(id: Int): NotificationEntity? {
        return notificationDao.getById(id)
    }

    override suspend fun getAll(): List<NotificationEntity> {
        return notificationDao.getAll()
    }

    override suspend fun deleteAll() {
        notificationDao.deleteAll()
    }
}
