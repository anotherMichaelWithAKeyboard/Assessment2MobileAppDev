package com.example.assessment2mobileappdev.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiRequest(
    val yourFirstName: String,
    val yourStudentId:String
)

data class LoginResponse(
    val myKeypass: String = "fashion"
)
