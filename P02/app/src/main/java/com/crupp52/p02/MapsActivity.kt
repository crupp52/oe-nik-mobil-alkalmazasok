package com.crupp52.p02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crupp52.p02.model.LocationInfo
import com.crupp52.p02.model.User
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var user: User
    private lateinit var locationInfo: LocationInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        user = intent.getSerializableExtra("user") as User

        locationInfo = when (user.school) {
            1 -> LocationInfo(LatLng(47.5333222, 19.0333535), "Óbudai Egyetem")
            2 -> LocationInfo(LatLng(47.4961328, 19.0360638), "Apor Vilmos Katolikus Főiskola Felnőttképzési Központ")
            3 -> LocationInfo(LatLng(46.0945173, 19.6599401), "Szabadkai Műszaki Főiskola")
            4 -> LocationInfo(LatLng(47.4813261, 19.0532947), "Budapesti Műszaki és Gazdaságtudományi Egyetem")
            else -> LocationInfo(LatLng(0.0, 0.0), "Zero")
        }

        mMap = googleMap
        mMap.addMarker(MarkerOptions().position(locationInfo.latLng).title(locationInfo.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationInfo.latLng, 15f))
    }
}
