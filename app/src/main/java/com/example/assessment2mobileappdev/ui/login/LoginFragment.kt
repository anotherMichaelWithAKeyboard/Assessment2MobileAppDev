package com.example.assessment2mobileappdev.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.ui.RestfulApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val TAG = "LoginFragment"

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // Share the same VM instance with DashboardFragment
    private val viewModel: RestfulApiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username: EditText = view.findViewById(R.id.inputTextLoginUsername)
        val password: EditText = view.findViewById(R.id.inputTextLoginPassword)
        val incorrectLoginTextView: TextView = view.findViewById(R.id.incorrectLoginText)
        val loginButton: Button = view.findViewById(R.id.loginButton)

        // Optional: observe errors from VM and show on login screen too
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collectLatest { err ->
                if (!err.isNullOrBlank()) {
                    Log.e(TAG, err)
                    incorrectLoginTextView.text = err
                }
            }
        }

        val expectedUsername = getString(R.string.expected_username)
        val expectedPassword = getString(R.string.expected_password)

        loginButton.setOnClickListener {
            val enteredUsername = username.text?.toString()?.trim()
            val enteredPassword = password.text?.toString()?.trim()

            if (enteredUsername == expectedUsername && enteredPassword == expectedPassword) {
                Log.d(TAG, "Local login OK. Loading dashboard with keypass='fashion'...")
                // Behave like the "Load Dashboard" button:
                viewModel.onLoginClicked() // if your VM uses hardcoded "fashion"
                // OR call explicitly:
                // viewModel.loadDashboard("fashion")

                // Navigate to dashboard
                findNavController().navigate(
                    R.id.action_fragment_login_screen_to_fragment_dashboard_view
                )
            } else {
                Log.d(TAG, "Local login FAILED for user='$enteredUsername'")
                incorrectLoginTextView.text = getString(R.string.incorrect_login)
            }
        }
    }
}
