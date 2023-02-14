package com.chernikova.pethelp.notification

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.chernikova.pethelp.MainActivity
import com.chernikova.pethelp.R
import com.chernikova.pethelp.data.entity.AnimalCard
import java.util.*

object NotificationHelper {
    fun createNotification(context: Context, animalCard: AnimalCard) {
        val mIntent = Intent(context, MainActivity::class.java)

        val pendingIntent =
            PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context!!, NotificationConstants.CHANNEL_ID).apply {
            setSmallIcon(R.drawable.punch_clock)
            setContentTitle("Не забудьте посмотреть!")
            setContentText(animalCard.title)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setContentIntent(pendingIntent)
            setAutoCancel(true)
        }

        val notificationManager = NotificationManagerCompat.from(context)

        Glide.with(context)
            //говорим что нужен битмап
            .asBitmap()
            //указываем откуда загружать, это ссылка как на загрузку с API
            .load(animalCard.poster)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                }
                //Этот коллбэк отрабатоет когда мы успешно получим битмап
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    //Создаем нотификации в стиле big picture
                    builder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(resource))
                    //Обновляем нотификацю
                    notificationManager.notify(animalCard.id, builder.build())
                }
            })
        //Отправляем изначальную нотификацю в стандартном исполнении
        notificationManager.notify(animalCard.id, builder.build())
    }
    fun notificationSet(context: Context, animalCard: AnimalCard) {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        DatePickerDialog(context, { _, dpdYear, dpdMonth, dayOfMonth -> val timeSetListener =
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, pickerMinute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(
                    dpdYear,
                    dpdMonth,
                    dayOfMonth,
                    hourOfDay,
                    pickerMinute,
                    0
                )
                val dateTimeInMillis = pickedDateTime.timeInMillis
                //После того, как получим время, вызываем метод, который создаст Alarm
                createWatchLaterEvent(context, dateTimeInMillis, animalCard)
            }

            TimePickerDialog(
                context,
                timeSetListener,
                currentHour,
                currentMinute,
                true
            ).show()

        },
            currentYear,
            currentMonth,
            currentDay
        ).show()
    }
    @SuppressLint("UnspecifiedImmutableFlag")
    private fun createWatchLaterEvent(context: Context, dateTimeInMillis: Long, animalCard: AnimalCard) {
        //Получаем доступ к AlarmManager
        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //Создаем интент для запуска ресивера
        val intent = Intent(animalCard.title, null, context, ReminderBroadcast()::class.java)
        //Кладем в него фильм
        val bundle = Bundle()
        bundle.putParcelable(NotificationConstants.CARD_KEY, animalCard)
        intent.putExtra(NotificationConstants.CARD_BUNDLE_KEY, bundle)
        //Создаем пендинг интент для запуска извне приложения
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        //Устанавливаем Alarm
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            dateTimeInMillis,

            pendingIntent
        )
    }
}