package com.example.assignment.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignment.data.network.Api
import com.example.example.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {
    suspend fun getUserResponse(): LiveData<Country> {
        val country = MutableLiveData<Country>()
        val response: Response<Country> = Api().getResponse()
        country.value = response.body()
        return country
    }
}