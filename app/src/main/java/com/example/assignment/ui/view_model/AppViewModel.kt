package com.example.assignment.ui.view_model

import androidx.lifecycle.ViewModel
import com.example.assignment.app_interface.ResponseListener
import com.example.assignment.data.repositories.AppRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {

    var responseListener: ResponseListener? = null

    suspend fun onFetchDataFromServer() {
        responseListener?.onStarted()
        responseListener?.onSuccess(AppRepository().getUserResponse())
    }


}