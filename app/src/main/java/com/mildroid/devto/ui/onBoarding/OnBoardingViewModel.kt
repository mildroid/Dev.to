package com.mildroid.devto.ui.onBoarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mildroid.devto.data.DevRepository
import com.mildroid.devto.domain.Tag
import com.mildroid.devto.utils.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val repository: DevRepository
) : ViewModel() {

    private var page: Int = 1
    private val more = Tag.more

    init {
        getTags(page = page)
    }

    private val _tags = mutableStateListOf<Tag>()
    val tags: List<Tag> get() = _tags

    val selectedTags = mutableListOf<Tag>()

    private val _apiKey = mutableStateOf("")
    val apiKey: State<String> get() = _apiKey

    private fun getTags(page: Int) = viewModelScope.launch {
        repository
            .tags(page)
            .filter { it.backgroundColor != null && it.textColor != null }
            .toMutableList()
            .run {
                if (_tags.contains(more))
                    _tags.remove(more)

                add(more)
                _tags.addAll(this)
            }
    }

    fun loadMoreTags() {
        this.page += 1
        getTags(page)
    }

    fun tagSelected(tag: Tag) {

    }

    fun changeApiKey(newApiKey: String) {
        _apiKey.value = newApiKey
    }
}