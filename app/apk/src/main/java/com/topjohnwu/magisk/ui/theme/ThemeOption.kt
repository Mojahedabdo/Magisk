package com.topjohnwu.magisk.ui.theme

import android.os.Build
import androidx.annotation.StringRes
import com.topjohnwu.magisk.core.Config
import com.topjohnwu.magisk.ui.theme.themes.ThemeCatalog

enum class ThemeOption {
    Ruby,
    MemCho,
    Aqua,
    SungJinWoo,
    Default,
    Custom;

    @get:StringRes
    val labelRes: Int
        get() = ThemeCatalog.labelRes(this)

    companion object {
        val supportsDynamicColor: Boolean
            get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

        val selected: ThemeOption
            get() = entries.getOrNull(Config.themeOrdinal) ?: Default

        val displayOrder: List<ThemeOption>
            get() = ThemeCatalog.displayOrder
    }
}
