package com.example.assessment2mobileappdev.data.remote

import com.example.assessment2mobileappdev.data.model.ApiRequest
import com.example.assessment2mobileappdev.data.model.ApiResponse
import com.example.assessment2mobileappdev.data.model.LoginResponse
import com.example.assessment2mobileappdev.data.model.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("footscray/auth")
    suspend fun getLogin(@Body request: ApiRequest): Response<LoginResponse>

        // gets all objects from the dashboard.

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): Response<DashboardResponse>


    @GET("objects/{id}")
    suspend fun getObjectsById(@Path("id") id: Int): ApiResponse

    @GET("objects/search")
    suspend fun searchObjects(
        @Query("name") name: String,
        @Query("description") description: String
    ): List<ApiResponse>

    @POST("objects")
    suspend fun addObject(@Body objectData: ApiRequest): Response<ApiResponse>



}