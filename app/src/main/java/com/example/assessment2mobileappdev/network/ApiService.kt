package com.example.assessment2mobileappdev.network

import com.example.assessment2mobileappdev.data.ApiRequest
import com.example.assessment2mobileappdev.data.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response
interface ApiService {

    @GET("objects")
    suspend fun getAllObjects(): List<ApiResponse>

    @GET("objects/{id}")
    suspend fun getObjectsById(@Path("id") id: Int): ApiResponse

    @GET("objects/search")
    suspend fun searchObjects(
        @Query("name") name: String,
        @Query("description") description: String
    ): List<ApiResponse>

    @POST("objects")
    suspend fun addObject(@Body objectData: ApiRequest): Response<ApiResponse>

    @POST("footscray/auth")
    suspend fun login(@Body credentials: ApiRequest): Response<ApiResponse>


}