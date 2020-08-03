package com.fabiano.faoanime.seasonTests

import com.fabiano.faoanime.models.Season
import com.fabiano.faoanime.utils.Formatter
import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test

class SummerTests {
    private val expectedSeason = Season(year = 2020, name = "summer")

    @Test
    fun `Summer june EQUALS`() {
        val dateTime = "2020-06-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer july EQUALS`() {
        val dateTime = "2020-07-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer august EQUALS`() {
        val dateTime = "2020-08-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)

        Assert.assertEquals(season, expectedSeason)
    }


    @Test
    fun `Summer may NOTEQUALS`() {
        val dateTime = "2020-05-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }

    @Test
    fun `Summer semptember NOTEQUALS`() {
        val dateTime = "2020-09-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }
}