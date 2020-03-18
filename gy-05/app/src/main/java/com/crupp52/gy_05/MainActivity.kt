package com.crupp52.gy_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var convertMode = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calculate(view: View) {

        if (to_celsius.isChecked){
            result_text.text = ((input.text.toString().toDouble() - 32) / 1.8).toString()
        }else{
            result_text.text = (input.text.toString().toDouble() * 1.8 + 32).toString()
        }
    }
}
