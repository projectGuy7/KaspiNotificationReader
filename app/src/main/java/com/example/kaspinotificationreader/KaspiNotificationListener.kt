package com.example.kaspinotificationreader

import android.app.Notification
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KaspiNotificationListener: NotificationListenerService() {

    override fun onCreate() {
        super.onCreate()
        Log.i("SERVICE Created", "Created")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        val notification = sbn.notification
        val extras = notification.extras

        val text = extras.getString(Notification.EXTRA_TEXT)
        if(sbn.packageName == resources.getString(R.string.kaspi_package_name)) {
            NotificationState.updateNotificationText(text ?: "Empty String Error")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}