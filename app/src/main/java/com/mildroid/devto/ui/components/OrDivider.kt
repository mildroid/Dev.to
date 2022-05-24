package com.mildroid.devto.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mildroid.devto.ui.theme.spacing

@Composable
fun OrDivider(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = MaterialTheme.spacing.large)
        )

        Text(
            text = "OR",
            style = MaterialTheme.typography.caption
        )

        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = MaterialTheme.spacing.large)
        )
    }
}
