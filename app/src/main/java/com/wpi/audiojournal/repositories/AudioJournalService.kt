package com.wpi.audiojournal.repositories

import com.wpi.audiojournal.models.CategoriesDTO
import com.wpi.audiojournal.models.ProgramsDTO
import com.wpi.audiojournal.models.Schedule
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://audiojournal.org/wp-json/swws/v1/"

interface AudioJournalService {

    @GET("categories")
    fun getCategories(): Call<CategoriesDTO>

    @GET("category/{name}")
    fun getPrograms(@Path("name") name: String): Call<ProgramsDTO>

    @GET("schedule")
    fun getSchedule(): Call<Schedule>

    companion object {
        fun create(): AudioJournalService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(AudioJournalService::class.java)
        }
    }
}