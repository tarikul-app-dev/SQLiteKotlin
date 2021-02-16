package com.aleshatech.sqlitekotlin.retrofit

import com.aleshatech.sqlitekotlin.model.ImageM
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/list")
    fun getImageList(): Call<List<ImageM>>
}