package com.rizingsun.sunnyweather.logic.network

import com.rizingsun.sunnyweather.logic.model.Province
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

object ProvinceService {

    fun sendRequestWithOkHttp(): List<Province> {
        try {
            val client = OkHttpClient()
            val request = Request.Builder().url("http://flash.weather.com.cn/wmaps/xml/china.xml").build()
            val response = client.newCall(request).execute()
            val responseData = response.body()?.string()
            if (responseData != null) {
                return parseXMLWithPull(responseData)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listOf()
    }

    fun parseXMLWithPull(xmlData: String) : List<Province> {
//        println("xmlData:$xmlData")
        val result = ArrayList<Province>()
        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))
            var eventType = xmlPullParser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val nodeName = xmlPullParser.name
                when(eventType) {
                    XmlPullParser.START_TAG -> {
                        when(nodeName) {
                            "city" ->
                                result.add(Province(xmlPullParser.getAttributeValue(0),
                                        xmlPullParser.getAttributeValue(1),
                                        xmlPullParser.getAttributeValue(2),
                                        xmlPullParser.getAttributeValue(3),
                                        xmlPullParser.getAttributeValue(4),
                                        xmlPullParser.getAttributeValue(5),
                                        xmlPullParser.getAttributeValue(6),
                                        xmlPullParser.getAttributeValue(7),
                                        xmlPullParser.getAttributeValue(8)))
                        }
                    }
                    /*XmlPullParser.END_TAG -> {

                    }*/
                }
                eventType = xmlPullParser.next()
            }

        }catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

}