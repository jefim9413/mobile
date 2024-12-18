package com.example.nighteventsapp.utils

import androidx.compose.runtime.mutableStateListOf

object NotificationManager {
    private val notifications = mutableStateListOf<String>()

    fun addNotification(message: String) {
        notifications.add(message)
    }

    fun getNotifications(): List<String> {
        return notifications
    }
}
