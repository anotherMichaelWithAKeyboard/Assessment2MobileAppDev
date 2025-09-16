package com.example.assessment2mobileappdev.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class DashboardResponse(
    val entities: List<Entity> = emptyList(),
    val entityTotal: Int?
)
@Parcelize
@JsonClass(generateAdapter = true)
data class Entity(
    @Json(name = "item_name") val itemName: String?,
    @Json(name = "designer") val designer: String?,
    @Json(name = "year_introduced") val yearIntroduced: Int?,
    @Json(name = "category") val category: String?,
    @Json(name = "material") val material: String?,
    @Json(name = "description") val description: String?
) : Parcelable
