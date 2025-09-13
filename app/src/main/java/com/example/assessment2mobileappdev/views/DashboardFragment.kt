package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.assessment2mobileappdev.R
import kotlin.getValue

class DashboardFragment: Fragment() {

    // private val arguments: DashboardFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_view, container, false)
    }


}