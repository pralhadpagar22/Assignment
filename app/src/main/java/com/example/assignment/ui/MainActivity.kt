package com.example.assignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.R
import com.example.assignment.app_interface.ResponseListener
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.ui.view_model.AppViewModel
import com.example.assignment.util.*
import com.example.example.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), ResponseListener {
    lateinit var viewModel: AppViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding.appViewModel = viewModel
        viewModel.responseListener = this
        setToolbarText("loading...")

        binding.swiperefresh.setOnRefreshListener {
            loadDataFromServer()
        }
    }

    override fun onStarted() {
        toast("Fetch data from server")
        binding.progressBar.show()
    }

    override fun onSuccess(country: LiveData<Country>) {
        country.observe(this) {
            binding.progressBar.hide()
            setToolbarText(it.title.toString())
            binding.listView.loadData(this, it.rows)
            binding.swiperefresh.hideSwipeRefresh()
        }
    }

    override fun onFailure() {
        toast("Fetch data from server Unsuccessfully")
        binding.progressBar.hide()
    }

    override fun onResume() {
        super.onResume()
        loadDataFromServer()
    }

    private fun loadDataFromServer() {
       GlobalScope.launch(Dispatchers.Main) {
           viewModel.onFetchDataFromServer()
       }
    }
}