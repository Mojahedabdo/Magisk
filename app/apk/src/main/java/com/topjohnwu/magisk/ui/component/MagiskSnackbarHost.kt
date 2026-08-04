package com.topjohnwu.magisk.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MagiskSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier,
        snackbar = { data ->
            Surface(
                color = SnackbarDefaults.color,
                contentColor = SnackbarDefaults.contentColor,
                shape = MagiskComponentDefaults.CardShape,
                tonalElevation = 6.dp
            ) {
                Text(
                    text = data.visuals.message,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )
}
