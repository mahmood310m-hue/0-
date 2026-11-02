package com.kawther.school

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationHelper {
    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(NotificationChannel("news", "أخبار المدرسة", NotificationManager.IMPORTANCE_HIGH))
            manager.createNotificationChannel(NotificationChannel("reminders", "تذكيرات", NotificationManager.IMPORTANCE_DEFAULT))
        }
    }

    fun showWelcomeNotification(context: Context, username: String) {
        val intent = Intent(context, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        val pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        
        val notification = NotificationCompat.Builder(context, "news")
            .setSmallIcon(android.R.drawable.ic_dialog_info) // أيقونة مؤقتة حتى تضيف أيقونتك
            .setContentTitle("مرحباً $username 👋")
            .setContentText("أهلاً بك في تطبيق مدرسة كوثر الأهلية")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pi)
            .build()
            
        (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(1, notification)
    }
}