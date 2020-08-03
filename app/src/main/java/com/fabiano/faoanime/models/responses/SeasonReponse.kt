package com.fabiano.faoanime.models.responses

import com.fabiano.faoanime.models.Anime
import com.google.gson.annotations.SerializedName

data class SeasonReponse(
    @SerializedName("request_hash")
    val requestHash: String? = null,
    @SerializedName("request_cached")
    val requestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,
    @SerializedName("season_name")
    val seasonName: String? = null,
    @SerializedName("season_year")
    val seasonYear: Int? = null,
    @SerializedName("anime")
    val results: ArrayList<Anime>? = null
)