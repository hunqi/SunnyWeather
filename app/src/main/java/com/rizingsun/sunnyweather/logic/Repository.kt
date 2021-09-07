package com.rizingsun.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.rizingsun.sunnyweather.logic.model.Province
import com.rizingsun.sunnyweather.logic.model.Region
import com.rizingsun.sunnyweather.logic.network.ProvinceService
import com.rizingsun.sunnyweather.logic.network.RegionService
import kotlinx.coroutines.Dispatchers
import java.lang.AssertionError
import java.lang.Exception

object Repository {

//    var provinces: List<Province> = listOf()
    var regions: List<Region> = listOf()

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        Log.i("Repository", query)

        val result = try {
            /*if (provinces.isEmpty()) {
                provinces = ProvinceService.sendRequestWithOkHttp()
            }*/

            if (regions.isEmpty()) {
                regions = RegionService.loadRegions()
            }

            Result.success(getMatchedRegions(query))
        } catch (e: Exception) {
            Result.failure<List<String>>(e)
        }
        emit(result)
    }

    private fun getMatchedRegions(query: String): List<Region> {

        if (query == null || query.trim().isEmpty()) {
            return listOf()
        }

        val result: MutableList<Region> = mutableListOf()
        val condition = query.trim()
        regions.forEach {
            if(it.name.indexOf(condition) > -1) {
                result.add(it)
            }
        }

        return result
    }

    /*fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = PlaceService2.sendRequestWithOkHttp()
            if (placeResponse.status == "ok" ) {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }*/

}