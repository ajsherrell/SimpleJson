package com.ajsherrell.android.simplejson


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Quiz(
    @Json(name = "category")
    val category: List<Category>
)