package com.crupp52.weatherjson.model


import com.google.gson.annotations.SerializedName

data class WeatherReportList(
    @SerializedName("list")
    val list: List<WeatherReport>
)