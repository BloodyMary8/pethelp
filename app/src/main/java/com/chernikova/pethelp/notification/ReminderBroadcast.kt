package com.chernikova.pethelp.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.chernikova.pethelp.data.entity.AnimalCard

class ReminderBroadcast: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.getBundleExtra(NotificationConstants.CARD_BUNDLE_KEY)
        val animalCard: AnimalCard = bundle?.get(NotificationConstants.CARD_KEY) as AnimalCard

        NotificationHelper.createNotification(context!!, animalCard)
    }
}