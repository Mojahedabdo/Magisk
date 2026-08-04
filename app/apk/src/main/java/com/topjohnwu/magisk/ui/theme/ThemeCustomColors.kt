package com.topjohnwu.magisk.ui.theme

import androidx.annotation.StringRes
import com.topjohnwu.magisk.core.Config
import com.topjohnwu.magisk.core.R as CoreR

enum class ThemeCustomColorSlot(@param:StringRes val labelRes: Int) {
    LightPrimary(CoreR.string.theme_color_light_primary),
    DarkPrimary(CoreR.string.theme_color_dark_primary),
    LightSecondary(CoreR.string.theme_color_light_secondary),
    DarkSecondary(CoreR.string.theme_color_dark_secondary),
    LightSurface(CoreR.string.theme_color_light_surface),
    DarkSurface(CoreR.string.theme_color_dark_surface),
    LightOnSurface(CoreR.string.theme_color_light_on_surface),
    DarkOnSurface(CoreR.string.theme_color_dark_on_surface),
    LightError(CoreR.string.theme_color_light_error),
    DarkError(CoreR.string.theme_color_dark_error)
}

data class ThemeCustomColors(
    val lightPrimary: Int,
    val darkPrimary: Int,
    val lightSecondary: Int,
    val darkSecondary: Int,
    val lightSurface: Int,
    val darkSurface: Int,
    val lightOnSurface: Int,
    val darkOnSurface: Int,
    val lightError: Int,
    val darkError: Int
) {
    fun value(slot: ThemeCustomColorSlot): Int = when (slot) {
        ThemeCustomColorSlot.LightPrimary -> lightPrimary
        ThemeCustomColorSlot.DarkPrimary -> darkPrimary
        ThemeCustomColorSlot.LightSecondary -> lightSecondary
        ThemeCustomColorSlot.DarkSecondary -> darkSecondary
        ThemeCustomColorSlot.LightSurface -> lightSurface
        ThemeCustomColorSlot.DarkSurface -> darkSurface
        ThemeCustomColorSlot.LightOnSurface -> lightOnSurface
        ThemeCustomColorSlot.DarkOnSurface -> darkOnSurface
        ThemeCustomColorSlot.LightError -> lightError
        ThemeCustomColorSlot.DarkError -> darkError
    }

    fun update(slot: ThemeCustomColorSlot, colorInt: Int): ThemeCustomColors = when (slot) {
        ThemeCustomColorSlot.LightPrimary -> copy(lightPrimary = colorInt)
        ThemeCustomColorSlot.DarkPrimary -> copy(darkPrimary = colorInt)
        ThemeCustomColorSlot.LightSecondary -> copy(lightSecondary = colorInt)
        ThemeCustomColorSlot.DarkSecondary -> copy(darkSecondary = colorInt)
        ThemeCustomColorSlot.LightSurface -> copy(lightSurface = colorInt)
        ThemeCustomColorSlot.DarkSurface -> copy(darkSurface = colorInt)
        ThemeCustomColorSlot.LightOnSurface -> copy(lightOnSurface = colorInt)
        ThemeCustomColorSlot.DarkOnSurface -> copy(darkOnSurface = colorInt)
        ThemeCustomColorSlot.LightError -> copy(lightError = colorInt)
        ThemeCustomColorSlot.DarkError -> copy(darkError = colorInt)
    }

    fun persistToConfig() {
        Config.themeCustomLightPrimary = lightPrimary
        Config.themeCustomDarkPrimary = darkPrimary
        Config.themeCustomLightSecondary = lightSecondary
        Config.themeCustomDarkSecondary = darkSecondary
        Config.themeCustomLightSurface = lightSurface
        Config.themeCustomDarkSurface = darkSurface
        Config.themeCustomLightOnSurface = lightOnSurface
        Config.themeCustomDarkOnSurface = darkOnSurface
        Config.themeCustomLightError = lightError
        Config.themeCustomDarkError = darkError
    }

    companion object {
        fun fromConfig(): ThemeCustomColors = ThemeCustomColors(
            lightPrimary = Config.themeCustomLightPrimary,
            darkPrimary = Config.themeCustomDarkPrimary,
            lightSecondary = Config.themeCustomLightSecondary,
            darkSecondary = Config.themeCustomDarkSecondary,
            lightSurface = Config.themeCustomLightSurface,
            darkSurface = Config.themeCustomDarkSurface,
            lightOnSurface = Config.themeCustomLightOnSurface,
            darkOnSurface = Config.themeCustomDarkOnSurface,
            lightError = Config.themeCustomLightError,
            darkError = Config.themeCustomDarkError
        )
    }
}
