package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assessment2mobileappdev.R

class FragmentViewController: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    //add override modifier to this fun.
    fun onViewCreate(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialise views and setup fragment logic here

        val dashboard_fragment_view :View
        val loginButton: Button = view.findViewById<Button>(R.id.loginButton)

        fun onClickLoginButton() {
            loginButton.setOnClickListener {
                findNavController().navigate(R.id.action_fragment_login_screen_to_fragment_dashboard_view)
            }
        }

    }
}