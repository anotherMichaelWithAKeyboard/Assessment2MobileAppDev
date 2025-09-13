package com.example.assessment2mobileappdev

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.assessment2mobileappdev.views.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

class MainActivity : AppCompatActivity() {
    /*
    private lateinit var textView: TextView
    private val viewModel: MainViewModel by viewModels()

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /*
        textView = findViewById(R.id.textView)

        lifecycleScope.launch() {
            viewModel.text.collect {newText ->
                textView.text = newText
            }
        }

         */
    }



}