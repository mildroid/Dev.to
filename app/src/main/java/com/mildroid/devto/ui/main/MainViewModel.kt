package com.mildroid.devto.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mildroid.devto.data.DevRepository
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

    val notReadyYet = MutableStateFlow(true)

    fun publishedArticles(page: Int = 1) = viewModelScope.launch {
        repository
            .publishedArticles(page)
            .forEach {
                it.log()
            }

        ready()
    }

    private suspend fun ready() {
        delay(500)
        notReadyYet.value = false
    }
}