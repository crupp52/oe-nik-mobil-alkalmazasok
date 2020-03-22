package com.crupp52.p02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.crupp52.p02.model.User
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.view.*

class AddActivity : AppCompatActivity() {

    var gender = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    fun addPerson(view: View) {

        val school =
            when (findViewById<RadioButton>(school_radio.checkedRadioButtonId).text.toString()) {
                "Óbudai Egyetem" -> 1
                "Apor Vilmos Katolikus Főiskola" -> 2
                "Szabadkai Műszaki Főiskola" -> 3
                "Műszaki Egyetem" -> 4
                else -> 0
            }

        val website = if (!fav_website.text.toString().startsWith("http://") && !fav_website.text.toString().startsWith("https://")) {
            "http://" + fav_website.text.toString()
        } else {
            fav_website.text.toString()
        }

        val intent = Intent(this, PersonalActivity::class.java)
        intent.putExtra(
            "user",
            User(
                name.text.toString(),
                website,
                phone_number.text.toString(),
                gender,
                school
            )
        )
        startActivity(intent)


    }

    fun setFemale(view: View) {
        gender = 1
        female_image.setImageResource(R.drawable.female_red)
        male_image.setImageResource(R.drawable.male)
    }

    fun setMale(view: View) {
        gender = 2
        male_image.setImageResource(R.drawable.male_blue)
        female_image.setImageResource(R.drawable.female)
    }
}
