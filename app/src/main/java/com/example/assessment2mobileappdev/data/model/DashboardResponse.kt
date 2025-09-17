// data/model/DashboardResponse.kt
package com.example.assessment2mobileappdev.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class EntitiesResponse(
    @Json(name = "entities") val entities: List<Entity> = emptyList(),
    @Json(name = "entityTotal") val entityTotal: Int? = null
)

@Parcelize
@JsonClass(generateAdapter = true)
data class Entity(
    @Json(name = "itemName") val itemName: String?,
    @Json(name = "designer") val designer: String?,
    @Json(name = "yearIntroduced") val yearIntroduced: Int?,
    @Json(name = "category") val category: String?,
    @Json(name = "material") val material: String?,
    @Json(name = "description") val description: String?
) : Parcelable

fun Entity.normalized() = Entity(
    itemName = itemName?.takeIf { it.isNotBlank() } ?: "(Unnamed)",
    designer = designer?.takeIf { it.isNotBlank() } ?: "(Unknown)",
    yearIntroduced = yearIntroduced ?: 0,
    category = category ?: "",
    material = material ?: "",
    description = description ?: ""
)