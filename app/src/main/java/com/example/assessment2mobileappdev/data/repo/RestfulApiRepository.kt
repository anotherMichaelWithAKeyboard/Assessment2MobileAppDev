package com.example.assessment2mobileappdev.data.repo

import com.example.assessment2mobileappdev.data.model.ApiRequest
import com.example.assessment2mobileappdev.data.remote.ApiService
import jakarta.inject.Inject

class RestfulApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDashboard(keypass: String) = apiService.getDashboard(keypass)
    suspend fun getLogin(request: ApiRequest) = apiService.getLogin(request)
    suspend fun getObjectsById(id: Int) = apiService.getObjectsById(id)
    suspend fun addObject(newObject: ApiRequest) = apiService.addObject(newObject)
}