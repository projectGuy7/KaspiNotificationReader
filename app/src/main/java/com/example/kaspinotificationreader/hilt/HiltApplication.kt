package com.example.kaspinotificationreader.hilt

import android.app.Application
import com.example.kaspinotificationreader.notification.NotificationApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: NotificationApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}