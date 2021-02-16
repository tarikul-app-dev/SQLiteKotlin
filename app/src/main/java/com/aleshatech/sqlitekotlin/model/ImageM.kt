package com.aleshatech.sqlitekotlin.model

import com.google.gson.annotations.SerializedName

data class ImageM (@SerializedName("id") val id : Int,
                   @SerializedName("author") val author : String,
                   @SerializedName("width") val width : Int,
                   @SerializedName("height") val height : Int,
                   @SerializedName("url") val url : String,
                   @SerializedName("download_url") val download_url : String = ""){

}