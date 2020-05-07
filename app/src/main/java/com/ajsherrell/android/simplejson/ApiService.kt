package com.ajsherrell.android.simplejson

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val BASE_URL = "https://api.npoint.io"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .build()

interface ApiService {
    @Headers("Accept: application/json")
    @GET("/68a0fdf29ebd9dc2774d/")
    suspend fun getQuiz(
//        @Path("category") category: List<String> = listOf("title", "questions")
    ): Quiz
}

object QuizApiService {
    val quizReportService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}