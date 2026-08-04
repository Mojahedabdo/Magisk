package com.topjohnwu.magisk.ui.theme.themes

import androidx.annotation.StringRes
import com.topjohnwu.magisk.ui.theme.ThemeOption

internal data class ThemeDefinition(
    val option: ThemeOption,
    @param:StringRes val labelRes: Int,
    val seed: () -> ThemeSeed
)
