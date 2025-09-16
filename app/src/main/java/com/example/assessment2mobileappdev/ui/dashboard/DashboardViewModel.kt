package com.example.assessment2mobileappdev.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2mobileappdev.data.model.DashboardResponse
import com.example.assessment2mobileappdev.data.repo.RestfulApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: RestfulApiRepository
) : ViewModel() {

    private val _dashboardResponse = MutableLiveData<DashboardResponse>()
    val dashboardResponse: LiveData<DashboardResponse> = _dashboardResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun fetchDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response: Response<DashboardResponse> = repository.getDashboard(keypass)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _dashboardResponse.value = it
                    } ?: run {
                        _errorMessage.value = "Empty response from server"
                    }
                } else {
                    _errorMessage.value = "Error: ${response.code()} ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Exception: ${e.localizedMessage}"
            }
        }
    }
}