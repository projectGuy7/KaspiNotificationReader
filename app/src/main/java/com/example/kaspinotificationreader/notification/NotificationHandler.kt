package com.example.kaspinotificationreader.notification

import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.kaspinotificationreader.R
import javax.inject.Inject
import kotlin.random.Random

class NotificationHandler @Inject constructor(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    private val notificationChannelID = "task_notification"

    fun showNotification() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Title")
            .setContentText("Description")
            .setSmallIcon(R.drawable.notification_icon)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
        Log.i("Came", "HERE")
    }
}