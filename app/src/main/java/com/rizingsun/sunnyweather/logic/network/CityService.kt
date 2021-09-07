package com.rizingsun.sunnyweather.logic.network

import com.rizingsun.sunnyweather.logic.model.City
import com.rizingsun.sunnyweather.logic.model.Province
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

object CityService {
    fun parseXMLWithPull(xmlData: String?): MutableList<City> {

        val result = mutableListOf<City>()
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
                                result.add(City(xmlPullParser.getAttributeValue(0),
                                        xmlPullParser.getAttributeValue(1),
                                        xmlPullParser.getAttributeValue(2),
                                        xmlPullParser.getAttributeValue(3),
                                        xmlPullParser.getAttributeValue(4),
                                        xmlPullParser.getAttributeValue(5),
                                        xmlPullParser.getAttributeValue(6),
                                        xmlPullParser.getAttributeValue(7),
                                        xmlPullParser.getAttributeValue(8),
                                        xmlPullParser.getAttributeValue(9),
                                        xmlPullParser.getAttributeValue(10),
                                        xmlPullParser.getAttributeValue(11),
                                        xmlPullParser.getAttributeValue(12),
                                        xmlPullParser.getAttributeValue(13),
                                        xmlPullParser.getAttributeValue(14),
                                        xmlPullParser.getAttributeValue(15),
                                        xmlPullParser.getAttributeValue(16),
                                        xmlPullParser.getAttributeValue(17)))
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
