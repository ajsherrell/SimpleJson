package com.ajsherrell.android.simplejson


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "questions")
    val questions: List<Question>,
    @Json(name = "title")
    val title: String
)