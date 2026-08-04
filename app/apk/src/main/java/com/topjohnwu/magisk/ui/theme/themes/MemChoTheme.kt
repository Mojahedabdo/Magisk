package com.topjohnwu.magisk.ui.theme.themes

import androidx.compose.ui.graphics.Color
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal val MemChoThemeDefinition = ThemeDefinition(
    option = ThemeOption.MemCho,
    labelRes = CoreR.string.theme_option_memcho,
    seed = {
        ThemeSeed(
            lightPrimary = Color(0xFFFFD54F),
            darkPrimary = Color(0xFFFFE082),
            lightSecondary = Color(0xFFFBC02D),
            darkSecondary = Color(0xFFFFD54F),
            lightTertiary = blend(Color(0xFFFFD54F), Color(0xFFFBC02D), 0.42f),
            darkTertiary = blend(Color(0xFFFFE082), Color(0xFFFFD54F), 0.42f),
            lightSurface = Color(0xFFFFFBEA),
            darkSurface = Color(0xFF211E10),
            lightOnSurface = Color(0xFF3E2723),
            darkOnSurface = Color(0xFFFFF9C4),
            lightError = Color(0xFFB00020),
            darkError = Color(0xFFCF6679)
        )
    }
)
