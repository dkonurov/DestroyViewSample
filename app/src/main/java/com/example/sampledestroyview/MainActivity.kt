package com.example.sampledestroyview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.root_container, MainFragment())
                .commit()
        }

        var count = 0
        replace.setOnClickListener {
            val tag = "${count++}"
            supportFragmentManager.beginTransaction()
                .replace(R.id.root_container, MainFragment(), tag)
                .addToBackStack(tag)
                .commit()
        }
    }
}
