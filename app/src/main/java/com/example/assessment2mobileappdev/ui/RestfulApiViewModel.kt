// ui/RestfulApiViewModel.kt
package com.example.assessment2mobileappdev.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2mobileappdev.data.model.Entity
import com.example.assessment2mobileappdev.data.model.normalized
import com.example.assessment2mobileappdev.data.repo.RestfulApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

private const val TAG = "DashboardVM"

sealed interface DashboardUiState {
    data object Idle : DashboardUiState
    data object Loading : DashboardUiState
    data class Success(val data: List<Entity>) : DashboardUiState
    data class Offline(val message: String) : DashboardUiState
    data class Error(val message: String) : DashboardUiState
}

@HiltViewModel
class RestfulApiViewModel @Inject constructor(
    private val repository: RestfulApiRepository
) : ViewModel() {

    private val _keypass = MutableStateFlow("fashion")
    val keypass: StateFlow<String> = _keypass

    private val _entities = MutableStateFlow<List<Entity>>(emptyList())
    val entities: StateFlow<List<Entity>> = _entities

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Idle)
    val uiState: StateFlow<DashboardUiState> = _uiState

    fun onLoginClicked() {
        refresh(_keypass.value)
    }

    fun refresh(kp: String = _keypass.value, preDelayMs: Long = 0L) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = DashboardUiState.Loading
            try {
                if (preDelayMs > 0) kotlinx.coroutines.delay(preDelayMs)

                // ensure network on IO (we're already on IO, but be explicit if you reuse elsewhere)
                val list = withContext(Dispatchers.IO) { repository.getEntities(kp) }
                    .map { it.normalized() }

                _entities.value = list
                _error.value = null
                _uiState.value = DashboardUiState.Success(list)
            } catch (e: UnknownHostException) {
                val msg = "Offline / can’t resolve host"
                Log.e(TAG, msg, e)
                _error.value = msg
                _uiState.value = DashboardUiState.Offline(msg)
            } catch (e: HttpException) {
                val msg = "HTTP ${e.code()} ${e.message()}"
                Log.e(TAG, msg, e)
                _error.value = msg
                _uiState.value = DashboardUiState.Error(msg)
            } catch (e: Exception) {
                val msg = e.message ?: "Unexpected error"
                Log.e(TAG, msg, e)
                _error.value = msg
                _uiState.value = DashboardUiState.Error(msg)
            }
        }
    }
}
