package com.ghedamsisabri.ui_testing_for_beginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        findViewById<Button>(R.id.button_back).setOnClickListener {
            onBackPressed()
        }
    }
}