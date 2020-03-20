package com.crupp52.weatherjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.crupp52.weatherjson.controller.WeatherReportAdapter
import com.crupp52.weatherjson.controller.WeatherReportController
import com.crupp52.weatherjson.model.WeatherReport
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var jsonString = "{\"list\":[{\"dt\":1471255200,\"temp\":{\"day\":30.04,\"min\":17.35,\"max\":30.04\n" +
                "},\"pressure\":1018.83,\"humidity\":35,\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"de\n" +
                "scription\":\"scattered clouds\",\"icon\":\"03d\"}],\"speed\":2.66, \"deg\":314,\n" +
                "\"clouds\":48},{\"dt\":1471341600,\"temp\":{\"day\":29.48,\"min\":19.3,\"max\":29.95\n" +
                "},\"pressure\":1018.63,\"humidity\":100,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"des\n" +
                "cription\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":2.46,\"deg\":28,\n" +
                "\"clouds\":92,\"rain\":8.5},{\"dt\":1471428000,\"temp\":{\"day\":28.96,\"min\":17.84,\"m\n" +
                "ax\":297.54},\"pressure\":1012.1,\"humidity\":95,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":2.27,\"deg\":118,\n" +
                "\"clouds\":88,\"rain\":5.55},{\"dt\":1471514400,\"temp\":{\"day\":26.89,\"min\":17.84,\"\n" +
                "max\":28.95},\"pressure\":1014.27,\"humidity\":83,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.98,\"deg\":93,\n" +
                "\"clouds\":20},{\"dt\":1471600800,\"temp\":{\"day\":30.04,\"min\":21.87,\"max\":30.04},\n" +
                "\"pressure\":1014.65,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"descrip\n" +
                "tion\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.66,\"deg\":194, \"clouds\":11,\n" +
                "\"rain\":0.22},{\"dt\":1471687200,\"temp\":{\"day\":31.3,\"min\":22.56,\"max\":32.3},\"p\n" +
                "ressure\":1018.6,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"descriptio\n" +
                "n\":\"light rain\",\"icon\":\"10d\"}],\"speed\":1.69,\"deg\":180, \"clouds\":16,\n" +
                "\"rain\":0.77} ,{\"dt\":1471773600,\"temp\":{\"day\":31.77,\"min\":21.67,\n" +
                "\"max\":30.77},\"pressure\":1016.93,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":2.49,\"deg\":227,\n" +
                "\"clouds\":14,\"rain\":2.2}]}"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherReportController = WeatherReportController()

        list_view.adapter = WeatherReportAdapter(this, weatherReportController.getData(jsonString).list)
    }
}
