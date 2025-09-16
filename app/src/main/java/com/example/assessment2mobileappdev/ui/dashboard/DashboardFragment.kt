package com.example.assessment2mobileappdev.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2mobileappdev.R
import com.example.assessment2mobileappdev.ui.RestfulApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    // Share the same VM instance created in LoginFragment
    private val viewModel: RestfulApiViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DashboardAdapter // assuming it takes List<Entity> + onClick

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.dashboardRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = DashboardAdapter(emptyList()) { entity ->
            // TODO: navigate to details if needed
            // val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(entity)
            // findNavController().navigate(action)
        }
        recyclerView.adapter = adapter

        // Observe data emitted by the shared ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.entities.collectLatest { list ->
                adapter.updateData(list)              // if using a simple Adapter
                // adapter.submitList(list)           // if you switch to ListAdapter + DiffUtil
            }
        }

        // Optional: observe and surface errors
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collectLatest { msg ->
                if (!msg.isNullOrBlank()) {
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}