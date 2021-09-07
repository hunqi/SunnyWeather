package com.rizingsun.sunnyweather.logic.network

import android.util.Log
import com.rizingsun.sunnyweather.logic.model.Region
import okhttp3.OkHttpClient
import okhttp3.Request

object RegionService {

    val baseUrl: String = "http://flash.weather.com.cn/wmaps/xml/%s.xml"

    fun loadRegions(): List<Region> {
        Log.i("RegionService", "begin loading region")

        try {
            val client = OkHttpClient()
            val provinceRequest = Request.Builder().url(String.format(baseUrl, "china")).build()
            val response = client.newCall(provinceRequest).execute()
            val responseData = response.body()?.string()
            if (responseData != null) {
                val provinces = ProvinceService.parseXMLWithPull(responseData)

                provinces.forEach {
                    Log.d("Province name", it.pyName)

                    val citiesRequest = Request.Builder().url(String.format(baseUrl, it.pyName)).build()

                    val response2 = client.newCall(citiesRequest).execute()
                    val responseData2 = response2.body()?.string()

                    val cities = CityService.parseXMLWithPull(responseData2)


                }


            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return mutableListOf()
    }

}
