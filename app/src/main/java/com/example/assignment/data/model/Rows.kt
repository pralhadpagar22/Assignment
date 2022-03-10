package com.example.example

import com.google.gson.annotations.SerializedName


data class Rows (

  @SerializedName("title"       ) var title       : String? = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("imageHref"   ) var imageHref   : String? = null

)