// MainActivity.kt
package com.example.assessment2mobileappdev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2mobileappdev.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}