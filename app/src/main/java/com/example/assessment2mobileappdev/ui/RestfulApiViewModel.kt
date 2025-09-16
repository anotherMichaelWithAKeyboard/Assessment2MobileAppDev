// RestfulApiViewModel.kt
package com.example.assessment2mobileappdev.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2mobileappdev.data.model.Entity
import com.example.assessment2mobileappdev.data.repo.RestfulApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DashboardVM"

@HiltViewModel
class RestfulApiViewModel @Inject constructor(
    private val repository: RestfulApiRepository
) : ViewModel() {

    // hardcode keypass per your request
    private val _keypass = MutableStateFlow("fashion")
    val keypass: StateFlow<String> = _keypass

    private val _entities = MutableStateFlow<List<Entity>>(emptyList())
    val entities: StateFlow<List<Entity>> = _entities

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    /** Call this when the login button is clicked */
    fun onLoginClicked() {
        val kp = _keypass.value
        Log.d(TAG, "Login clicked. Using keypass='$kp'. Fetching dashboard…")
        loadDashboard(kp)
    }

    private fun loadDashboard(kp: String) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "GET /dashboard/$kp -> starting request")
                val resp = repository.getDashboard(kp)
                Log.d(TAG, "GET /dashboard/$kp -> HTTP ${resp.code()}")

                if (resp.isSuccessful) {
                    val body = resp.body()
                    Log.d(TAG, "GET /dashboard/$kp -> entityTotal=${body?.entityTotal} items=${body?.entities?.size}")
                    _entities.value = body?.entities.orEmpty()
                } else {
                    val msg = "Dashboard failed: ${resp.code()} ${resp.message()}"
                    Log.e(TAG, msg)
                    _error.value = msg
                }
            } catch (e: Exception) {
                val msg = "Dashboard error: ${e.message}"
                Log.e(TAG, msg, e)
                _error.value = msg
            }
        }
    }
}
