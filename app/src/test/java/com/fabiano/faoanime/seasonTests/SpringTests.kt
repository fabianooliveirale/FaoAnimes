package com.fabiano.faoanime.seasonTests

import com.fabiano.faoanime.models.Season
import com.fabiano.faoanime.utils.Formatter
import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test

class SpringTests {
    private val expectedSeason = Season(year = 2020, name = "spring")

    @Test
    fun `Summer march EQUALS`() {
        val dateTime = "2020-03-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer april EQUALS`() {
        val dateTime = "2020-04-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer may EQUALS`() {
        val dateTime = "2020-05-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertEquals(season, expectedSeason)
    }

    @Test
    fun `Summer june NOTEQUALS`() {
        val dateTime = "2020-06-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }

    @Test
    fun `Summer february NOTEQUALS`() {
        val dateTime = "2020-02-05"
        val time = DateTime.parse(dateTime)
        val season = Formatter().parseDateTimeToSeason(time)
        Assert.assertNotEquals(season, expectedSeason)
    }
}