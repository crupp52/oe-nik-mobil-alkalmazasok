package com.crupp52.p02.model

import com.google.android.gms.maps.model.LatLng

data class LocationInfo(
    val latLng: LatLng,
    val name: String
)
