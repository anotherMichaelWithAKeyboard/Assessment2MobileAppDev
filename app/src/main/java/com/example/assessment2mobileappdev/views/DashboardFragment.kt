package com.example.assessment2mobileappdev.views

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.savedstate.serialization.saved
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.data.User
import kotlinx.parcelize.Parcelize
import kotlin.getValue
@Parcelize
class DashboardFragment: Fragment(), Parcelable {
    //private val args: DashboardFragmentArgs by navArgs()
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_view, container, false)
    }


}