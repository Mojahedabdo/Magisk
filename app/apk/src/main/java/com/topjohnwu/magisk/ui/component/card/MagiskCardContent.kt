package com.topjohnwu.magisk.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MagiskCardContent(
    contentPadding: PaddingValues,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(contentPadding),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp),
        content = content
    )
}

