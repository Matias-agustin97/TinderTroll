package com.example.tinder

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class Myapp : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }


    private fun createNotificationChannel(){

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val chanel = NotificationChannel(
            CounterNotificationService.TINDER_CHANNEL_ID,
                "Tinder",
                NotificationManager.IMPORTANCE_HIGH
            )

            chanel.description="Te amo perdon no me mates"


            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(chanel)
        }
    }
}