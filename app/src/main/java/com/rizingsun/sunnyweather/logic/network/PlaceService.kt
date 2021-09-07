package com.rizingsun.sunnyweather.logic.network

import com.rizingsun.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}