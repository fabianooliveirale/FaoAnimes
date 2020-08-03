package com.fabiano.faoanime.utils

import com.fabiano.faoanime.models.Anime

class Filter {
    fun animeWithEpisode(anime: Anime): Boolean = anime.episodes != null
            && anime.episodes != 0
            && anime.rated?.toUpperCase() != "RX"
            && anime.r18 != true
            && anime.kids != true
}