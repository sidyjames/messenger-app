package com.example.h3messenger.ui.theme.utils

import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.time.chrono.ChronoLocalDateTime
import java.util.Date
import java.util.Locale

fun Date.toReadableDateTime(): String {
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentWeek = calendar.get(Calendar.WEEK_OF_YEAR)
    val currentDay = calendar.get(Calendar.DAY_OF_YEAR)


    calendar.time= this
    val targetYear = calendar.get(Calendar.YEAR)
    val targetWeek = calendar.get(Calendar.WEEK_OF_YEAR)
    val targetDay = calendar.get(Calendar.DAY_OF_YEAR)

    return when {
        currentDay == targetDay -> SimpleDateFormat("HH:mm", Locale.getDefault() ).format(this)
        currentWeek == targetWeek -> SimpleDateFormat("EEE 'at' HH:MM", Locale.getDefault() ).format(this)
        currentYear == targetYear -> SimpleDateFormat("dd 'of' MMM", Locale.getDefault() ).format(this)
        else -> SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault() ).format(this)
    }
}