package com.crupp52.p02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.crupp52.p02.model.User
import kotlinx.android.synthetic.main.activity_personal.*

class PersonalActivity : AppCompatActivity() {
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        val genderMap = mapOf(0 to "Nem meghározott", 1 to "Nő", 2 to "Férfi")
        val schoolMap = mapOf(
            0 to "Nem meghározott",
            1 to "http://uni-obuda.hu/",
            2 to "http://avkf.hu/",
            3 to "https://www.vts.su.ac.rs/hu",
            4 to "https://www.bme.hu/"
        )

        user = intent.getSerializableExtra("user") as User

        val initialNameStringBuilder = StringBuilder()
        for (item in user.name.split(' ').toTypedArray()) {
            initialNameStringBuilder.append(item[0].toUpperCase())
        }

        initial.text = initialNameStringBuilder.toString()
        gender.text = genderMap[user.gender]
        phone_number.text = user.phoneNumber.toString().substring(0, 2)
        fav_website.text = user.website
        school.text = schoolMap[user.school]
    }

    fun openLocation(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("user", user)

        startActivity(intent)
    }

    fun openWebsite(view: View) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(fav_website.text.toString())))
    }
}
