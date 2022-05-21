package com.mildroid.devto.data

import com.mildroid.devto.data.remote.DevApi
import javax.inject.Inject

class DevRepository @Inject constructor(
    private val devApi: DevApi
) {

    suspend fun publishedArticles(page: Int = 1) = devApi.publishedArticles(page = page)

}