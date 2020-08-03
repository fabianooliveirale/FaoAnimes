package com.fabiano.faoanime.models

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("mal_id")
    val malId: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("airing")
    val airing: String? = null,
    @SerializedName("synopsis")
    val synopsis: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("episodes")
    val episodes: Int? = null,
    @SerializedName("score")
    val score: Float? = null,
    @SerializedName("start_date")
    val startDate: String? = null,
    @SerializedName("end_date")
    val endDate: String? = null,
    @SerializedName("members")
    val members: Int? = null,
    @SerializedName("rated")
    val rated: String? = null,
    @SerializedName("r18")
    val r18: Boolean? = null,
    @SerializedName("kids")
    val kids: Boolean? = null,
    @SerializedName("genres")
    val genres: ArrayList<Genres>? = null
)