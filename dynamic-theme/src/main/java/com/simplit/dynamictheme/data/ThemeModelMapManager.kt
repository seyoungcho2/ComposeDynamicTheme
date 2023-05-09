package com.simplit.dynamictheme.data

import com.simplit.dynamictheme.model.ThemeModel
import com.simplit.dynamictheme.model.ThemeModelKey

internal class ThemeModelMapManager internal constructor() {
    private var defaultThemeModel = ThemeModel()

    private val themeModelMap: MutableMap<ThemeModelKey, ThemeModel> = mutableMapOf(
        ThemeModelKey.Default to defaultThemeModel
    )

    fun removeThemeModel(key: ThemeModelKey) {
        themeModelMap.remove(key)
    }

    fun putThemeModel(key: ThemeModelKey, themeModel: ThemeModel) {
        themeModelMap[key] = themeModel
    }

    fun getThemeModel(key: ThemeModelKey): ThemeModel {
        return themeModelMap[key] ?: defaultThemeModel
    }

    fun getSupportedThemeModels(): Map<ThemeModelKey, ThemeModel> = themeModelMap

    fun setDefaultThemeModel(themeModel: ThemeModel) {
        defaultThemeModel = themeModel
        themeModelMap[ThemeModelKey.Default] = themeModel
    }

    fun getDefaultThemeModel(): ThemeModel {
        return themeModelMap[ThemeModelKey.Default] ?: defaultThemeModel
    }
}