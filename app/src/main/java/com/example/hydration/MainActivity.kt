package com.example.hydration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val waterViewModel by lazy {
        WaterViewModelFactory((application as HydrationApplication).repository).create(WaterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tuesday = WaterRecord("Tuesday", 4)
        waterViewModel.insertNewRecord(tuesday)
        val wednesday = WaterRecord("Wednesday", 4)
        waterViewModel.insertNewRecord(wednesday)

        waterViewModel.allRecords.observe(this) { records ->
            Log.d("MAIN_ACTIVITY", "$records")
        }

        supportFragmentManager.beginTransaction().add(R.id.content, HydrationFragment.newInstance("Tuesday")).commit()

    }
}