package com.example.assessment2mobileappdev.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiRequest(
    @Json(name="username") val yourFirstName: String,
    @Json(name="password") val yourStudentId:String
)

data class LoginResponse(
    @Json val keypass: String
)
