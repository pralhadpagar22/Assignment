package com.example.assignment.app_interface

import androidx.lifecycle.LiveData
import com.example.example.Country

interface ResponseListener {
    fun onStarted()
    fun onSuccess(country: LiveData<Country>)
    fun onFailure()
}