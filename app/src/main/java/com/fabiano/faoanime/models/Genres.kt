package com.fabiano.faoanime.models

import com.google.gson.annotations.SerializedName

data class Genres (
    @SerializedName("mal_id")
    val malId: Boolean? = null,
    @SerializedName("type")
    val type: Boolean? = null,
    @SerializedName("name")
    val name: Boolean? = null,
    @SerializedName("url")
    val url: Boolean? = null
)