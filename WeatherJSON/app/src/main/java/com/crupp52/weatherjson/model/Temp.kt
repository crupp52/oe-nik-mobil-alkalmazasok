package com.crupp52.weatherjson.model


import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("day")
    val day: Double,
    @SerializedName("max")
    val max: Double,
    @SerializedName("min")
    val min: Double
)