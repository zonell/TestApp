package com.example.testapp.utils.extension

import com.example.room.data.room.entity.NotificationEntity
import com.example.testapp.ui.view.categoriesItem.model.CategoriesItem

fun List<NotificationEntity>.toShow(): List<CategoriesItem> {
    val list = mutableListOf<CategoriesItem>()

    this.forEach {
        list.add(
            CategoriesItem(
                it.icon,
                it.title,
                it.description,
                false
            )
        )
    }

    return list
}

fun List<CategoriesItem>.toDb(): List<NotificationEntity> {
    val list = mutableListOf<NotificationEntity>()

    this.forEach {
        list.add(
            NotificationEntity(
                0,
                it.title,
                it.description,
                it.icon,
            )
        )
    }

    return list
}