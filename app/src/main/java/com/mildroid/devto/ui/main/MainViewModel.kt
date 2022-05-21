package com.mildroid.devto.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mildroid.devto.data.DevRepository
import com.mildroid.devto.utils.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DevRepository
) : ViewModel() {

    fun publishedArticles(page: Int = 1) = viewModelScope.launch {
        repository
            .publishedArticles(page)
            .forEach {
                it.log()
            }
    }

}