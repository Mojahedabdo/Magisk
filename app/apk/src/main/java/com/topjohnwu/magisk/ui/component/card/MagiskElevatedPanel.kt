package com.topjohnwu.magisk.ui.component.card

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.topjohnwu.magisk.ui.component.MagiskComponentDefaults

@Composable
fun MagiskElevatedPanel(
    modifier: Modifier = Modifier,
    shape: Shape = MagiskComponentDefaults.PanelShape,
    tonalElevation: Dp = 1.dp,
    shadowElevation: Dp = 0.dp,
    color: Color = MagiskComponentDefaults.PanelContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = color,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = MagiskComponentDefaults.CardBorder,
        content = content
    )
}
