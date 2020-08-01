package com.fabiano.faoanime.models.responses

import com.fabiano.faoanime.models.Anime
import com.google.gson.annotations.SerializedName

data class SearchReponse(
    @SerializedName("request_hash")
    val requestHash: String? = null,
    @SerializedName("request_cached")
    val requestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,
    @SerializedName("results")
    val results: ArrayList<Anime>? = null
)