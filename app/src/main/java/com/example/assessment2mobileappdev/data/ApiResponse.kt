package com.example.assessment2mobileappdev.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "keypass") val  myKeypass: String
)
