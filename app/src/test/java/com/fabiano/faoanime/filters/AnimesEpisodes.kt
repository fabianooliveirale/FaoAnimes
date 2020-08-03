package com.fabiano.faoanime.filters

import com.fabiano.faoanime.models.Anime
import com.fabiano.faoanime.utils.Filter
import org.junit.Assert
import org.junit.Test

class AnimesEpisodes {
    private val anime_one = Anime(episodes = 200)
    private val anime_null = Anime()
    private val anime_zero = Anime(episodes = 0)
    private val anime_rx = Anime(rated = "Rx")
    private val anime_kids = Anime(r18 = true)
    private val anime_r18 = Anime(kids = true)

    @Test
    fun `Anime Zero Ep`() {
        val expected = Filter().animeWithEpisode(anime_zero)
        Assert.assertFalse(expected)
    }

    @Test
    fun `Anime null Ep`() {
        val expected = Filter().animeWithEpisode(anime_null)
        Assert.assertFalse(expected)
    }

    @Test
    fun `Anime more than zero Ep`() {
        val expected = Filter().animeWithEpisode(anime_one)
        Assert.assertTrue(expected)
    }

    @Test
    fun `Anime RX Ep`() {
        val expected = Filter().animeWithEpisode(anime_rx)
        Assert.assertFalse(expected)
    }

    @Test
    fun `Anime Kids Ep`() {
        val expected = Filter().animeWithEpisode(anime_kids)
        Assert.assertFalse(expected)
    }

    @Test
    fun `Anime R18 Ep`() {
        val expected = Filter().animeWithEpisode(anime_r18)
        Assert.assertFalse(expected)
    }
}