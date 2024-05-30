package com.example.room.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notification")
class NotificationEntity(
    @PrimaryKey(autoGenerate = true)
    val idKey: Int,
    val title: String,
    val description: String,
    val icon: Int
)