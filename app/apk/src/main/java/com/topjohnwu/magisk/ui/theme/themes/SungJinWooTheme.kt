package com.topjohnwu.magisk.ui.theme.themes

import androidx.compose.ui.graphics.Color
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal val SungJinWooThemeDefinition = ThemeDefinition(
    option = ThemeOption.SungJinWoo,
    labelRes = CoreR.string.theme_option_sung_jinwoo,
    seed = {
        ThemeSeed(
            lightPrimary = Color(0xFF9575CD),
            darkPrimary = Color(0xFFB39DDB),
            lightSecondary = Color(0xFF5E35B1),
            darkSecondary = Color(0xFF9575CD),
            lightTertiary = blend(Color(0xFF9575CD), Color(0xFF5E35B1), 0.42f),
            darkTertiary = blend(Color(0xFFB39DDB), Color(0xFF9575CD), 0.42f),
            lightSurface = Color(0xFFF6F1FF),
            darkSurface = Color(0xFF12101F),
            lightOnSurface = Color(0xFF311B92),
            darkOnSurface = Color(0xFFEDE7F6),
            lightError = Color(0xFFB00020),
            darkError = Color(0xFFCF6679)
        )
    }
)
