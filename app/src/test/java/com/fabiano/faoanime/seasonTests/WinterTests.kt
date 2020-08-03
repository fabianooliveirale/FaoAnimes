package com.fabiano.faoanime.seasonTests

import com.fabiano.faoanime.models.Season
import com.fabiano.faoanime.utils.Formatter
import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test

class WinterTests {
    private val expectedSeason = Season(year = 2020, name = "winter")

    @Test
    fun `Summer december EQUALS`() {
        val dateTime = "2020-12-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer januery EQUALS`() {
        val dateTime = "2020-01-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer february EQUALS`() {
        val dateTime = "2020-02-05"
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