package io.github.seyoungcho2.dynamicthemesample.theme.name

import io.github.seyoungcho2.dynamictheme.model.ThemeModelKey
import io.github.seyoungcho2.dynamicthemesample.theme.ThemeModels

class ThemeNameRepository {
    private val themeNames: Map<ThemeModelKey, String> = mapOf(
        ThemeModels.THEME_MODEL_KEY_DEFAULT to "Default",
        ThemeModels.THEME_MODEL_KEY_WHITE to "White",
        ThemeModels.THEME_MODEL_KEY_BLACK to "Black",
        ThemeModels.THEME_MODEL_KEY_PINK to "Pink",
        ThemeModels.THEME_MODEL_KEY_BLUE to "Blue"
    )

    fun getThemeName(key: ThemeModelKey): String {
        return themeNames[key] ?: EMPTY_STRING
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}