package com.example.assignment.data.network

import com.example.example.Country
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("/v3/c4ab4c1c-9a55-4174-9ed2-cbbe0738eedf")
    suspend fun getResponse(): Response<Country>

    companion object {
        operator fun invoke() : Api {
            return Retrofit.Builder()
                .baseUrl(" https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }
}