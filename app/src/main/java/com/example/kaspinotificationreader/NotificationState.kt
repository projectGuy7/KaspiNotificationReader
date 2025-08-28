package com.example.kaspinotificationreader

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object NotificationState {
    private val _state = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()

    fun updateNotificationText(text: String) {
        _state.value = text
    }
}