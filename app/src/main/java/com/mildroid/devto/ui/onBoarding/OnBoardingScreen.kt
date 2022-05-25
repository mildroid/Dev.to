package com.mildroid.devto.ui.onBoarding

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.mildroid.devto.ui.components.OrDivider
import com.mildroid.devto.ui.components.TagChip
import com.mildroid.devto.ui.theme.Blue700
import com.mildroid.devto.ui.theme.spacing
import com.mildroid.devto.utils.DEV_ACCOUNT_URL
import com.mildroid.devto.utils.launchBrowser
import com.mildroid.devto.utils.log


@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    navigateToHomeScreen: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TagListBar(viewModel) },
        bottomBar = { BottomBar(navigateToHomeScreen) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OrDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            )

            ApiKeyBar(viewModel)
        }
    }
}

@Composable
fun TagListBar(viewModel: OnBoardingViewModel) {
    "tagListBar".log()
    Column(
        modifier = Modifier
//            .recomposeHighlighter()
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.small),
            text = "Follow some tags to get started!",
            fontSize = 22.sp
        )

        val tags = viewModel.tags
        tags.size.log("TAG SIZE ON")

        val scrollState = rememberScrollState()

/*
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.spacing.extraLarge)
//                .padding(top = MaterialTheme.spacing.large)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Transparent,
                        )
                    )
                )
        )
*/

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
        ) {
            FlowRow(
                modifier = Modifier
//                .recomposeHighlighter()
                    .fillMaxSize()
                    .padding(top = MaterialTheme.spacing.small)
                    .verticalScroll(scrollState),
                mainAxisSpacing = 16.dp,
                crossAxisSpacing = 16.dp,
            ) {
                LaunchedEffect(tags.size) {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                )

                tags.forEach { tag ->
                    var isSelected by
                    mutableStateOf(tag.isSelected)

                    TagChip(
                        selected = isSelected,
                        tag = tag,
                        modifier = Modifier
//                        .recomposeHighlighter()
                            .clickable {
                                if (tag.id == -11) {
                                    viewModel.loadMoreTags()
                                } else {
                                    if (isSelected) {
                                        viewModel.selectedTags.remove(tag)
                                    } else {
                                        viewModel.selectedTags.add(tag)
                                    }

                                    isSelected = !isSelected
                                    tag.isSelected = isSelected
                                }
                            }
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.background,
                                Color.Transparent
                            ),
                            endY = 100f
                        )
                    )
            )

        }

    }
}

@Composable
fun ApiKeyBar(
    viewModel: OnBoardingViewModel,
    ctx: Context = LocalContext.current
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.spacing.large,
                vertical = MaterialTheme.spacing.small
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val getApiText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            ) {
                append("You can use your Dev.to API key! Get it from ")
            }

            pushStringAnnotation("get API key", "google.com")
            withStyle(
                style = SpanStyle(
                    color = Blue700
                )
            ) {
                append("here!")
            }
            pop()
        }

        ClickableText(
            text = getApiText,
            style = MaterialTheme.typography.body1,
            onClick = { offset ->
                getApiText.getStringAnnotations(
                    tag = "get API key",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                        ctx.launchBrowser(DEV_ACCOUNT_URL)
                }
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small),
            value = viewModel.apiKey.value,
            onValueChange = { viewModel.changeApiKey(it) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent, //hide the indicator
            ),
            placeholder = { Text(
                text = "API Key",
                fontSize = 16.sp
            ) },
            textStyle = TextStyle(fontSize = 16.sp)
        )
    }
}

@Composable
fun BottomBar(navigateToHomeScreen: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.large),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(0.6f),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            onClick = {
                navigateToHomeScreen()
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(MaterialTheme.spacing.extraSmall),
                text = "Get Started",
            )
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