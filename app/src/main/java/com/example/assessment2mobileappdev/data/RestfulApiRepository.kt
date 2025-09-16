package com.example.assessment2mobileappdev.data

import com.example.assessment2mobileappdev.network.ApiService
import com.example.assessment2mobileappdev.network.RestfulApiDevRetrofitClient
import jakarta.inject.Inject
import retrofit2.Response


class RestfulApiRepository (val apiService: ApiService = RestfulApiDevRetrofitClient().apiService) {

    suspend fun getAllObjects():List<ApiResponse> {
        return apiService.getAllObjects()
    }

    suspend fun getObjectsById(id: Int): ApiResponse {
        return apiService.getObjectsById(id)
    }

    suspend fun addObject(newObject: ApiRequest): Response<ApiResponse> {
        return apiService.addObject(newObject)
    }


}