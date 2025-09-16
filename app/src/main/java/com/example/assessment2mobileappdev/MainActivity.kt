package com.example.assessment2mobileappdev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2mobileappdev.views.FragmentViewController
import dagger.hilt.android.AndroidEntryPoint


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