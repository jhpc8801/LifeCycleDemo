package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var x : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate")

        val btn : Button = findViewById(R.id.btnOk)
        val tv : TextView = findViewById(R.id.tvResult)

        // if it is the first time, then it is null
        // if the phone is rotated, and the data is saved, then get the data and put back
        if (savedInstanceState != null) {
            x = savedInstanceState.getInt("value")
            tv.text = x.toString()

        }

        btn.setOnClickListener() {
            // examples of some calculation
            x = 100
            tv.text = x.toString()
        }

    }

    // to save the data before the phone rotated
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("value", x)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
}