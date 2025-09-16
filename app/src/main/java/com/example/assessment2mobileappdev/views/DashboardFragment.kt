package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.savedstate.serialization.saved
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.data.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import kotlin.getValue

class DashboardFragment: Fragment() {
    //private val args: DashboardFragmentArgs by navArgs()
    private val viewModel: RestfulApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.textViewData)
        val button = view.findViewById<Button>(R.id.get_objects_button)

        // button to fetch data
        button.setOnClickListener {
            viewModel.getAllObjects()
        }

        lifecycleScope.launch {
            viewModel.keypassSate.collect {key ->
                key?.let {
                    Log.d("API", "Recieved Keypass: $it")
                }
            }
        }
        viewModel.login("mikaere", "8090942")

        // Collect StateFlow from ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.objectsState.collectLatest { state ->
                textView.text = state.toString()
            }
        }
    }


}