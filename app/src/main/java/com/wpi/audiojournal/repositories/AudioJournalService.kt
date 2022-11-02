package com.wpi.audiojournal.repositories

import android.net.Uri
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wpi.audiojournal.models.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://audiojournal.org/wp-json/swws/v1/"

interface AudioJournalServiceInterface {

    @Nested("categories")
    @Mapped
    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>

    @Nested("programs")
    @Mapped
    @GET("category/{name}")
    suspend fun getPrograms(@Path("name") name: String): Response<List<Program>>

    @GET("podcast/{name}")
    suspend fun getProgram(@Path("name") name: String): Response<Program>

    @GET("schedule")
    suspend fun getSchedule(): Response<Map<String, Map<String, String>>>

    @GET("streamsource")
    suspend fun getLiveLink(): Response<Uri>
}

val moshi: Moshi = Moshi.Builder()
    .add(NestedFactory.INSTANCE)
    .add(MappedFactory.INSTANCE)
    .add(KotlinJsonAdapterFactory())
    .add(object {
        @FromJson
        fun fromJson (string: String) = Uri.parse(string)
        @ToJson
        fun toJson (uri: Uri) = uri.toString()
    })
    .build()

val AudioJournalService: AudioJournalServiceInterface by lazy {
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
        .create(AudioJournalServiceInterface::class.java)
}