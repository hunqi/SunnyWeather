package com.rizingsun.sunnyweather.logic.network

import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.await
import retrofit2.http.GET

fun main() = runBlocking {
    val placeSrv = ServiceCreator.create(PlaceSrv::class.java)
    val placeResp = placeSrv.search().await()
    println(placeResp.weatherinfo)
}

interface PlaceSrv {
    @GET("data/sk/101280601.html")
    fun search(): Call<PlaceResp>
}

data class PlaceResp(val weatherinfo: WeatherInfo) {
    override fun toString(): String {
        return "{weatherinfo:${weatherinfo}}"
    }
}

data class WeatherInfo(val city: String,
                       val cityId: String,
                       val temp: String,
                       val WD: String,
                       val SD: String,
                       val AP: String,
                       val njd: String,
                       val WSE: String,
                       val time: String,
                       val sm: String,
                       val isRadar: String,
                        val Radar: String) {
    override fun toString(): String {
        return "{city:$city,cityId:$cityId,temp:$temp,WD:$WD,SD:$SD,AP:$AP,njd:$njd,WSE:$WSE,time:$time,sm:$sm,isRadar:$isRadar,Radar:$Radar}"
    }
}