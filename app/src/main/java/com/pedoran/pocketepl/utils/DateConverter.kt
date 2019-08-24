package com.pedoran.pocketepl.utils

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    fun formatDateToMatch(date: Date): String {
        return SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(date)
    }

    fun formatStringDateToAge(dob : String?): String{
        val parts = dob?.split("-")

        val birth = Calendar.getInstance()
        birth.set(parts!![0].toInt(),parts!![1].toInt(),parts!![2].toInt())
        val today = Calendar.getInstance()

        var age = today.get(Calendar.YEAR)- birth.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR)<birth.get(Calendar.DAY_OF_YEAR)){ age-- }

        return age.toString()
    }
}