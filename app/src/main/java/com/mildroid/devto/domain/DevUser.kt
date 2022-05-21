package com.mildroid.devto.domain

import com.squareup.moshi.Json

data class DevUser(
    val name: String,
    val username: String,

    @field:Json(name = "twitter_username")
    val twitterUsername: String?,

    @field:Json(name = "github_username")
    val githubUsername: String,

    @field:Json(name = "website_url")
    val websiteURL: String?,

    @field:Json(name = "profile_image")
    val profileImage: String,

    @field:Json(name = "profile_image_90")
    val profileImage90: String
)