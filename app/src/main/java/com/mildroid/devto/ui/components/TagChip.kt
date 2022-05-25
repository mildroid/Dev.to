package com.mildroid.devto.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mildroid.devto.domain.Tag
import com.mildroid.devto.ui.theme.spacing
import com.mildroid.devto.utils.toColor

@Composable
fun TagChip(
    selected: Boolean,
    tag: Tag,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = tag.backgroundColor!!.toColor.copy(alpha = 0.7f)
        )
    ) {
        Surface(
            modifier = modifier,
            color = when {
                selected -> tag.backgroundColor.toColor.copy(alpha = 0.4f)
                else -> Color.Transparent
            },
            contentColor = Color.LightGray
        ) {
            // Add text to show the data that we passed
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.medium,
                        vertical = MaterialTheme.spacing.small
                    ),
                text = if (tag.name == "More...") tag.name else "#${tag.name}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2
            )
        }
        /*
        if (tag.id == -11 && tag.isSelected) {
            CircularProgressIndicator(
                modifier = Modifier
                    .scale(0.5f)
                    .padding(MaterialTheme.spacing.none)
            )
        }
        */
    }
}
