package com.example.assessment2mobileappdev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2mobileappdev.views.FragmentViewController

class MainActivity : AppCompatActivity() {
    /*
    private lateinit var textView: TextView
    private val viewModel: MainViewModel by viewModels()

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_view)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragment_container_view, FragmentViewController::class.java,null)
            .commit()

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