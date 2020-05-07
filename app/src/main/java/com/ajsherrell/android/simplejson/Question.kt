package com.ajsherrell.android.simplejson


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Question(
    @Json(name = "answer")
    val answer: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "options")
    val options: List<String>,
    @Json(name = "questionText")
    val questionText: String
)