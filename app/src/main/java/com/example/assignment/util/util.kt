package com.example.assignment.util

import android.content.Context
import android.view.View
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.assignment.adapter.CustomListAdapter
import com.example.example.Rows

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}

fun AppCompatActivity.setToolbarText(title: String) {
    this.supportActionBar?.title = title
}

fun ListView.loadData(context:Context, rows: ArrayList<Rows>) {
    CustomListAdapter(context, rows).also { adapter = it }
}

fun SwipeRefreshLayout.hideSwipeRefresh() {
    isRefreshing = false
}
