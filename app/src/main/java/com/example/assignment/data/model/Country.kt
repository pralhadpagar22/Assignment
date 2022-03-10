package com.example.example

import com.google.gson.annotations.SerializedName


data class Country (

  @SerializedName("title" ) var title : String?         = null,
  @SerializedName("rows"  ) var rows  : ArrayList<Rows> = arrayListOf()

)