package com.mildroid.devto.ui.onBoarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mildroid.devto.domain.Tag
import com.mildroid.devto.ui.components.OrDivider
import com.mildroid.devto.ui.theme.spacing
import com.mildroid.devto.utils.toColor

@Composable
fun OnBoardingScreen(
    navigateToHomeScreen: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Add your API key if you hav one")

            OrDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.large)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Button(onClick = navigateToHomeScreen) {
                    Text(text = "To Home")
                }
                Text(text = "Hello OnBoarding", fontSize = 22.sp)
            }

        }
    }
}

@Composable
fun TopBar() {
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "You have to option to get started!"
    )
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = {}) {
            Text(text = "Next")
        }
    }
}

/*
    private val viewModel: MainViewModel by viewModels()

    private val tags = mutableListOf<Tag>()

*                     val tags by viewModel.tags
                    this.tags.addAll(tags)

                    val scrollState = rememberScrollState()
                    val scope = rememberCoroutineScope()

                    FlowRow(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(material.spacing.large),
                        mainAxisSpacing = 16.dp,
                        crossAxisSpacing = 16.dp,
                    ) {
                        this@MainActivity.tags.forEach { tag ->
                            scope.launch {
                                scrollState.animateScrollTo(scrollState.maxValue)
                            }

                            var isSelected by remember {
                                mutableStateOf(
                                    viewModel.selectedTags.contains(
                                        tag
                                    )
                                )
                            }
                            isSelected.log(tag.name)

                            CustomChip(
                                selected = isSelected,
                                tag = tag,
                                modifier = Modifier
                                    .clickable {
                                        if (tag.id == -11) {
                                            this@MainActivity.tags.removeLast()
                                            viewModel.loadMoreTags()
                                        } else {
                                            if (isSelected) {
                                                viewModel.selectedTags.remove(tag)
                                            } else {
                                                viewModel.selectedTags.add(tag)
                                            }
                                            this@MainActivity.tags.find { it == tag }?.isSelected =
                                                isSelected
                                            isSelected = !isSelected
                                        }

                                    }
                            )
                        }
                    }*/