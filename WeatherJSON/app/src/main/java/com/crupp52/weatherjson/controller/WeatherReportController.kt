package com.crupp52.weatherjson.controller

import com.crupp52.weatherjson.model.WeatherReportList
import com.google.gson.Gson

class WeatherReportController {
    fun getData(json: String): WeatherReportList {
        return Gson().fromJson(json, WeatherReportList::class.java)
    }
}
