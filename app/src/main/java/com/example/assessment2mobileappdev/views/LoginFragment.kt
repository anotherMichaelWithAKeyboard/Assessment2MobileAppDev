package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assessment2mobileappdev.R
import dagger.hilt.android.AndroidEntryPoint


class LoginFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // iniitate values for input
        val username: EditText = view.findViewById<EditText>(R.id.inputTextLoginUsername)
        val password: EditText = view.findViewById<EditText>(R.id.inputTextLoginPassword)
        val incorrectLoginTextView: TextView = view.findViewById(R.id.incorrectLoginText)

        val  loginButton: Button = view.findViewById<Button>(R.id.loginButton)

        val expectedUsername = getString(R.string.expected_username)
        val expectedPassword = getString(R.string.expected_password)
        loginButton.setOnClickListener {
            val enteredUsername = username.text?.toString()
            val enteredPassword = password.text?.toString()
            if (enteredUsername == expectedUsername && enteredPassword == expectedPassword) {
                findNavController().navigate(R.id.action_fragment_login_screen_to_fragment_dashboard_view)
            } else {
                incorrectLoginTextView.text = getString(R.string.incorrect_login)
            }
        }
    }

}


