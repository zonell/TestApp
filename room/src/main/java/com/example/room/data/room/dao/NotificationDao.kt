package com.example.room.data.room.dao

import androidx.room.*
import com.example.room.data.room.entity.NotificationEntity

@Dao
interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notification: NotificationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notifications: List<NotificationEntity>)

    @Update
    suspend fun update(notification: NotificationEntity)

    @Delete
    suspend fun delete(notification: NotificationEntity)

    @Query("SELECT * FROM notification WHERE idKey = :id")
    suspend fun getById(id: Int): NotificationEntity?

    @Query("SELECT * FROM notification")
    suspend fun getAll(): List<NotificationEntity>

    @Query("DELETE FROM notification")
    suspend fun deleteAll()
}
