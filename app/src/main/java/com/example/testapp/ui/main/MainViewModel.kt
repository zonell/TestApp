package com.example.testapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.data.useCase.notofication.NotificationUseCase
import com.example.testapp.ui.view.categoriesItem.model.CategoriesItem
import com.example.testapp.utils.extension.toDb
import com.example.testapp.utils.extension.toShow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(
    private val notificationUseCase: NotificationUseCase
) : ViewModel() {


    private val _notifications = MutableLiveData<List<CategoriesItem>>()
    val notifications: LiveData<List<CategoriesItem>> get() = _notifications

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _uniqueNumbers = MutableLiveData<Set<Int>>()
    val uniqueNumbers: LiveData<Set<Int>> get() = _uniqueNumbers

    init {
        checkCategory()
    }

    private fun checkCategory() {
        viewModelScope.launch {
            kotlin.runCatching {
                notificationUseCase.getAllNotifications()
            }.onSuccess {
                if (it.isNotEmpty()) {
                    getNotification()
                } else {
                    kotlin.runCatching {
                        notificationUseCase.insert(CategoriesItem.getCategories().toDb())
                    }.onSuccess {
                        kotlin.runCatching {
                            notificationUseCase.getAllNotifications()
                        }.onSuccess {
                            getNotification()
                        }
                    }
                }
            }
        }
    }

    fun generateNumbers() {
        viewModelScope.launch {
            val initialNumber = Random.nextInt(1, 7)

            val uniqueNumbersSet = mutableSetOf<Int>()

            while (uniqueNumbersSet.size < initialNumber) {
                delay(500)
                val nextNumber = Random.nextInt(0, 6)
                if (uniqueNumbersSet.add(nextNumber)) {
                    _uniqueNumbers.value = uniqueNumbersSet

                    val list = notifications.value

                    val updatedList = list?.mapIndexed { index, notificationEntity ->
                        if (index == nextNumber) {
                            notificationEntity.updateIsError(true)
                        } else {
                            notificationEntity
                        }
                    }

                    _notifications.value = updatedList
                }
            }
        }
    }

    private fun getNotification() {
        viewModelScope.launch {
            kotlin.runCatching {
                notificationUseCase.getAllNotifications()
            }.onSuccess {
                _notifications.value = it.toShow()
            }.onFailure {
                _error.value = it.message
            }
        }
    }
}