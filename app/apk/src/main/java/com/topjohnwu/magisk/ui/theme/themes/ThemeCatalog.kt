package com.topjohnwu.magisk.ui.theme.themes

import androidx.annotation.StringRes
import com.topjohnwu.magisk.ui.theme.ThemeOption
import com.topjohnwu.magisk.core.R as CoreR

internal object ThemeCatalog {
    private val definitions = listOf(
        DefaultThemeDefinition,
        CustomThemeDefinition,
        RubyThemeDefinition,
        MemChoThemeDefinition,
        AquaThemeDefinition,
        SungJinWooThemeDefinition
    )

    val displayOrder: List<ThemeOption> = definitions.map { it.option }

    @StringRes
    fun labelRes(option: ThemeOption): Int {
        if (option == ThemeOption.Default && !ThemeOption.supportsDynamicColor) {
            return CoreR.string.theme_option_default_automatic
        }
        return definitionOf(option).labelRes
    }

    fun seedFor(option: ThemeOption): ThemeSeed = definitionOf(option).seed()

    private fun definitionOf(option: ThemeOption): ThemeDefinition {
        return definitions.firstOrNull { it.option == option } ?: definitions.first()
    }
}
