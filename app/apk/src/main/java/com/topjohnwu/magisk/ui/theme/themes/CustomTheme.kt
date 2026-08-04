package com.topjohnwu.magisk.ui.theme.themes

import androidx.compose.ui.graphics.Color
import com.topjohnwu.magisk.core.Config
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal val CustomThemeDefinition = ThemeDefinition(
    option = ThemeOption.Custom,
    labelRes = CoreR.string.theme_option_custom,
    seed = {
        ThemeSeed(
            lightPrimary = Color(Config.themeCustomLightPrimary),
            darkPrimary = Color(Config.themeCustomDarkPrimary),
            lightSecondary = Color(Config.themeCustomLightSecondary),
            darkSecondary = Color(Config.themeCustomDarkSecondary),
            lightTertiary = blend(
                Color(Config.themeCustomLightPrimary),
                Color(Config.themeCustomLightSecondary),
                0.42f
            ),
            darkTertiary = blend(
                Color(Config.themeCustomDarkPrimary),
                Color(Config.themeCustomDarkSecondary),
                0.42f
            ),
            lightSurface = Color(Config.themeCustomLightSurface),
            darkSurface = Color(Config.themeCustomDarkSurface),
            lightOnSurface = Color(Config.themeCustomLightOnSurface),
            darkOnSurface = Color(Config.themeCustomDarkOnSurface),
            lightError = Color(Config.themeCustomLightError),
            darkError = Color(Config.themeCustomDarkError)
        )
    }
)
