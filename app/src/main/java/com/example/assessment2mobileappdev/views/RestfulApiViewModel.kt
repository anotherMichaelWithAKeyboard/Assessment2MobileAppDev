package com.example.assessment2mobileappdev.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2mobileappdev.data.ApiRequest
import com.example.assessment2mobileappdev.data.ApiResponse
import com.example.assessment2mobileappdev.data.RestfulApiRepository
import com.example.assessment2mobileappdev.network.RestfulApiDevRetrofitClient
import com.example.assessment2mobileappdev.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestfulApiViewModel: ViewModel() {

    private val repository = RestfulApiRepository()
    private val mutableObjectsState = MutableStateFlow<List<ApiResponse>>(emptyList())
    val objectsState: MutableStateFlow<List<ApiResponse>> = mutableObjectsState
    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun getAllObjects() {
        viewModelScope.launch {
            try {
                val objects = repository.getAllObjects()
                mutableObjectsState.value = objects
            } catch (e: Exception) {
                _errorState.value = "Error fetching objects: ${e.message}"
            }
        }
    }

    private val _keypassState = MutableStateFlow<String?>(null)
    val keypassSate: StateFlow<String?> = _keypassState
    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val request = ApiRequest(username, password)
                val response = repository.apiService.login(request)

                if (response.isSuccessful) {
                    _keypassState.value = response.body()?.myKeypass?:"No keypass found"
                } else {
                    _keypassState.value = "Login failed: ${response.code()}"
                }

            } catch (e: Exception) {
                _keypassState.value = "Error fetching objects: ${e.message}"
            }
        }
    }


}