package com.example.assessment2mobileappdev.data.repo

import com.example.assessment2mobileappdev.data.model.ApiRequest
import com.example.assessment2mobileappdev.data.model.Entity
import com.example.assessment2mobileappdev.data.remote.ApiService
import javax.inject.Inject

class RestfulApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getEntities(keypass: String): List<Entity> {
        return apiService.getDashboard(keypass).entities
    }
    /*
    suspend fun getLogin(request: ApiRequest) = apiService.getLogin(request)
    suspend fun getObjectsById(id: Int) = apiService.getObjectsById(id)
    suspend fun addObject(newObject: ApiRequest) = apiService.addObject(newObject)
     */
}

