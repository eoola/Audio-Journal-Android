package com.wpi.audiojournal.repositories

import com.wpi.audiojournal.models.CategoriesDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://audiojournal.org/wp-json/swws/v1/"

interface AudioJournalService {
    

    @GET("categories")
    fun getCategories(): Call<CategoriesDTO>

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