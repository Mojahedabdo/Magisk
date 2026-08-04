package com.topjohnwu.magisk.ui.theme.themes

import androidx.compose.ui.graphics.Color
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal val RubyThemeDefinition = ThemeDefinition(
    option = ThemeOption.Ruby,
    labelRes = CoreR.string.theme_option_ruby,
    seed = {
        ThemeSeed(
            lightPrimary = Color(0xFFF06292),
            darkPrimary = Color(0xFFF48FB1),
            lightSecondary = Color(0xFFD81B60),
            darkSecondary = Color(0xFFF06292),
            lightTertiary = blend(Color(0xFFF06292), Color(0xFFD81B60), 0.42f),
            darkTertiary = blend(Color(0xFFF48FB1), Color(0xFFF06292), 0.42f),
            lightSurface = Color(0xFFFFF5F8),
            darkSurface = Color(0xFF211017),
            lightOnSurface = Color(0xFF3C1020),
            darkOnSurface = Color(0xFFFCE4EC),
            lightError = Color(0xFFB00020),
            darkError = Color(0xFFCF6679)
        )
    }
)
