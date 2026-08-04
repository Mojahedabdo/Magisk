package com.topjohnwu.magisk.ui.component.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.topjohnwu.magisk.ui.component.MagiskComponentDefaults

@Composable
fun MagiskOutlinedCard(
    modifier: Modifier = Modifier,
    shape: Shape = MagiskComponentDefaults.CardShape,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val colors = CardDefaults.outlinedCardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

    if (onClick == null) {
        OutlinedCard(
            modifier = modifier,
            shape = shape,
            colors = colors,
            content = content
        )
    } else {
        OutlinedCard(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = colors,
            content = content
        )
    }
}
