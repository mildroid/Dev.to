package com.mildroid.devto.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mildroid.devto.data.DevRepository
import com.mildroid.devto.domain.Tag
import com.mildroid.devto.utils.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DevRepository
) : ViewModel() {

    init {
        tags(1)
    }

    private val notReadyYet = MutableStateFlow(true)

    val tags: MutableState<List<Tag>> = mutableStateOf(emptyList())
    val selectedTags = mutableListOf<Tag>()

    private var page: Int = 1

    fun publishedArticles(page: Int = 1) = viewModelScope.launch {
        repository
            .publishedArticles(page)
            .forEach {
                it.log()
            }

        ready()
    }

    private fun tags(page: Int) = viewModelScope.launch {
        val tags = repository
            .tags(page)
            .filter { it.backgroundColor != null && it.textColor != null }
            .toMutableList()
            .also {
                it.add(Tag(-11, "More...", "#ffffff", "#ffffff"))
            }

        this@MainViewModel.tags.value = tags
    }

    fun loadMoreTags() {
        this.page += 1
        tags(this.page)
    }

    private suspend fun ready() {
        delay(500)
        notReadyYet.value = false
    }
}