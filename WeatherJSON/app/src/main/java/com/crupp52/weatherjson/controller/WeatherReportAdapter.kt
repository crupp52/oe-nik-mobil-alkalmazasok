package com.crupp52.weatherjson.controller

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.crupp52.weatherjson.R
import com.crupp52.weatherjson.model.WeatherReport
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.math.roundToInt

class WeatherReportAdapter(
    private val context: Context,
    private val dataSource: List<WeatherReport>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        view.list_item.text =
            "${dataSource[position].temp.max.roundToInt()}/${dataSource[position].temp.min.roundToInt()}, ${dataSource[position].weather.first().main}, Wind = ${dataSource[position].speed.roundToInt()}"
        return view
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}