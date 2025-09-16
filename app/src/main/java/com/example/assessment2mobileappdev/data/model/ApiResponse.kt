package com.example.assessment2mobileappdev.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    val itemName: String,
    val designer: String,
    val yearIntroduced: Int,
    val category: String,
    val material: String,
    val description: String
)