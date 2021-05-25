package com.example.harajtask.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    companion object {
        @SuppressLint("SimpleDateFormat")
        fun getDateFromLong(date: Long) : String{
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy hh.mm aa")
            val dateString = simpleDateFormat.format(date)
            return dateString
        }

        // here is if you want to display the date as ({$day} days ago) format
        private fun getDaysAgo(date: Date): String {
            val days: Long = (Date().getTime() - date.getTime()) / 86400000
            return if (days == 0L) "Today" else if (days == 1L) "Yesterday" else "$days days ago"
        }
    }
}