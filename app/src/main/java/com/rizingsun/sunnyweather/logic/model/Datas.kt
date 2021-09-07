package com.rizingsun.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class Province(
        val quName: String,
        val pyName: String,
        val citeName: String,
        val state1: String,
        val state2: String,
        val stateDetail: String,
        val temp1: String,
        val temp2: String,
        val windState: String)

data class City(val cityX: String,
                val cityY: String,
                @SerializedName("cityname") val cityName: String,
                @SerializedName("centername") val centerName: String,
                val fontColor: String,
                val pyName: String,
                val state1: String,
                val state2: String,
                val stateDetailed: String,
                val tem1: String,
                val tem2: String,
                val temNow: String,
                val windState: String,
                val windDir: String,
                val windPower: String,
                val humidity: String,
                val time: String,
                @SerializedName("url") val code: String)

data class Region(val name: String, val code: String)