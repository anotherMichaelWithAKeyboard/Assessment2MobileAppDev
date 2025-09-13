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
        val username: EditText = view.findViewById<EditText>(R.id.inputTextLoginUsername)
        val password: EditText = view.findViewById<EditText>(R.id.inputTextLoginPassword)
        val inputUsername = username.text?.toString()
        val inputPassword = password.text?.toString()
        var loginValid: Boolean = true
        val incorrectLoginTextView: TextView = view.findViewById(R.id.incorrectLoginText)
        val  loginButton: Button = view.findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            fun loginCheck(inputUsername:String?, inputPassword:String?) {
                when (inputUsername == "Mikaere" && inputPassword == "1") {
                    true -> {
                        findNavController().navigate(R.id.action_fragment_login_screen_to_fragment_dashboard_view)
                    }
                    false -> {
                        incorrectLoginTextView.text="incorrect_login"
                    }
                }
            }
            loginCheck(inputUsername,inputPassword)
            /*
            fun loginAccount(loginValid:Boolean = false) {
                when(loginValid) {
                    true -> {
                        findNavController().navigate(R.id.action_fragment_login_screen_to_fragment_dashboard_view)
                    }
                    false ->
                }
            }
             loginAccount()
             */



        }
    }

}


