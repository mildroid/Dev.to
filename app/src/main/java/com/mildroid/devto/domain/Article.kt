package com.mildroid.devto.domain

import com.squareup.moshi.Json

data class Article(

    @field:Json(name = "type_of")
    val typeOf: String,

    val id: Int,
    val title: String,
    val description: String,

    @field:Json(name = "readable_publish_date")
    val readablePublishDate: String,

    val slug: String,
    val path: String,
    val url: String,

    @field:Json(name = "comments_count")
    val commentsCount: Int,

    @field:Json(name = "public_reactions_count")
    val publicReactionsCount: Int,

    @field:Json(name = "collection_id")
    val collectionID: Any? = null,

    @field:Json(name = "published_timestamp")
    val publishedTimestamp: String,

    @field:Json(name = "positive_reactions_count")
    val positiveReactionsCount: Int,

    @field:Json(name = "cover_image")
    val coverImage: String?,

    @field:Json(name = "social_image")
    val socialImage: String,

    @field:Json(name = "canonical_url")
    val canonicalURL: String,

    @field:Json(name = "created_at")
    val createdAt: String,

    @field:Json(name = "edited_at")
    val editedAt: String?,

    @field:Json(name = "crossposted_at")
    val crosspostedAt: String?,

    @field:Json(name = "published_at")
    val publishedAt: String,

    @field:Json(name = "last_comment_at")
    val lastCommentAt: String,

    @field:Json(name = "reading_time_minutes")
    val readingTimeMinutes: Int,

    @field:Json(name = "tag_list")
    val tagList: List<String>,

    val tags: String,
    val user: DevUser
)