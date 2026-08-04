package com.topjohnwu.magisk.ui.theme.themes

import androidx.compose.ui.graphics.Color
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal val AquaThemeDefinition = ThemeDefinition(
    option = ThemeOption.Aqua,
    labelRes = CoreR.string.theme_option_aqua,
    seed = {
        ThemeSeed(
            lightPrimary = Color(0xFF4FC3F7),
            darkPrimary = Color(0xFF81D4FA),
            lightSecondary = Color(0xFF0288D1),
            darkSecondary = Color(0xFF4FC3F7),
            lightTertiary = blend(Color(0xFF4FC3F7), Color(0xFF0288D1), 0.42f),
            darkTertiary = blend(Color(0xFF81D4FA), Color(0xFF4FC3F7), 0.42f),
            lightSurface = Color(0xFFF0FBFF),
            darkSurface = Color(0xFF0D1820),
            lightOnSurface = Color(0xFF01579B),
            darkOnSurface = Color(0xFFE1F5FE),
            lightError = Color(0xFFB00020),
            darkError = Color(0xFFCF6679)
        )
    }
)
