package com.example.tinder

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun showNotification(){

        val activityIntent=Intent(context,MainActivity::class.java)

        val activityPendingIntent= PendingIntent.getActivity(context,1,activityIntent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
            )

        val TinderIntent= PendingIntent.getBroadcast(context,2,Intent(context,TinderNotificationReciever::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0)

        val notification = NotificationCompat.Builder(context, TINDER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("+9 nuevos mensajes")
            .setContentText("Tienes mensajes de Victoria Trans")
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_launcher_foreground,"Responder",TinderIntent)
            .build()

        notificationManager.notify(1,notification)
    }


    fun carlosxD(){
        val activityIntent=Intent(context,MainActivity::class.java)

        val activityPendingIntent= PendingIntent.getActivity(context,1,activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val TinderIntent= PendingIntent.getBroadcast(context,2,Intent(context,TinderNotificationReciever::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0)

        val notification = NotificationCompat.Builder(context, TINDER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(R.drawable.dogor))
            .setContentTitle("Tienes un nuevo match !")
            .setContentText("Has hecho match con Jose Alberto Fernandez Gutierrez")
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_launcher_foreground,"Ingresa para conectarte",TinderIntent)
            .build()

        notificationManager.notify(1,notification)
    }

    companion object{
        const val TINDER_CHANNEL_ID="tinder_channel"
    }
}