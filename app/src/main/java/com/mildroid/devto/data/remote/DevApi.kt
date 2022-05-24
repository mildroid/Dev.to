package com.mildroid.devto.data.remote

import com.mildroid.devto.domain.Article
import com.mildroid.devto.domain.Tag
import retrofit2.http.GET
import retrofit2.http.Query

interface DevApi {

    @GET("articles")
    suspend fun publishedArticles(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("tag") rag: String? = null,
        @Query("tags") tags: String? = null,
        @Query("tags_exclude") tagsExclude: String? = null,
        @Query("username") username: String? = null,
        @Query("state") state: String? = null,
        @Query("top") top: Int? = null,
        @Query("collection_id") CollectionId: Int? = null,

    ): List<Article>

    @GET("tags")
    suspend fun tags(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 15
    ): List<Tag>
}