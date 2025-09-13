package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assessment2mobileappdev.R

class FragmentViewController: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_screen, container, false)
    }

    //add override modifier to this fun.
    fun onViewCreate(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialise views and setup fragment logic here
        // val button = view.findViewById<Button>(R.id.button)
    }
}