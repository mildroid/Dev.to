package com.mildroid.devto.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(

    val id: Int,
    val name: String,

    @field:Json(name = "bg_color_hex")
    val backgroundColor: String?,

    @field:Json(name = "text_color_hex")
    val textColor: String?,

    @Transient
    var isSelected: Boolean = false
)