package io.github.seyoungcho2.dynamicthemesample.material3.theme

import io.github.seyoungcho2.dynamictheme.material3.model.ThemeModelKey

object ThemeNameRepository {
    private const val EMPTY_STRING = ""

    private val themeNames: Map<ThemeModelKey, String> = mapOf(
        ThemeModels.THEME_MODEL_KEY_DEFAULT to "Default",
        ThemeModels.THEME_MODEL_KEY_PURPLE to "Purple",
        ThemeModels.THEME_MODEL_KEY_WHITE to "White",
        ThemeModels.THEME_MODEL_KEY_BLACK to "Black",
        ThemeModels.THEME_MODEL_KEY_WHITE_PURPLE to "White Purple",
        ThemeModels.THEME_MODEL_KEY_WHITE_BLUE to "White Blue",
        ThemeModels.THEME_MODEL_KEY_NAVY to "Navy"
    )

    fun getThemeName(key: ThemeModelKey): String {
        return themeNames[key] ?: EMPTY_STRING
    }
}