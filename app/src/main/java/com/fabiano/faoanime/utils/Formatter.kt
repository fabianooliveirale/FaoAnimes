package com.fabiano.faoanime.utils

import com.fabiano.faoanime.models.Season
import org.joda.time.DateTime

class Formatter {
    fun parseDateTimeToSeason(dateTime: DateTime): Season {
        val year = dateTime.toString("YYYY").toInt()
        val mounth = dateTime.toString("MM").toInt()
        val seasonName = getSeasonName(mounth)
        return Season(year = year, name = seasonName)
    }

    private fun getSeasonName(mounth: Int): String {
        return when (mounth) {
            in 6..8 -> return "summer"
            in 9..11 -> return "autumn"
            in 3..5 -> return "spring"
            else -> "winter"
        }
    }
}