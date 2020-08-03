package com.fabiano.faoanime.seasonTests

import com.fabiano.faoanime.models.Season
import com.fabiano.faoanime.utils.Formatter
import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test

class AutumnTests {
    private val expectedSeason = Season(year = 2020, name = "autumn")

    @Test
    fun `Summer september EQUALS`() {
        val dateTime = "2020-09-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer october EQUALS`() {
        val dateTime = "2020-10-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer november EQUALS`() {
        val dateTime = "2020-11-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer january NOTEQUALS`() {
        val dateTime = "2020-01-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }

    @Test
    fun `Summer august NOTEQUALS`() {
        val dateTime = "2020-08-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }
}