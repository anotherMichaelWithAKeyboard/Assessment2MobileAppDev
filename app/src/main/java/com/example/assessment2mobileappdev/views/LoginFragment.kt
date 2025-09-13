package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.assessment2mobileappdev.R

class LoginFragment: Fragment() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val  loginButton: Button = view.findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_login_screen_to_fragment_dashboard_view)
        }
    }

}


