package com.simplit.dynamictheme.data

import com.simplit.dynamictheme.model.ThemeModel
import com.simplit.dynamictheme.model.ThemeModelKey

class ThemeModelMapManager internal constructor() {
    private val themeModelMap = mutableMapOf<ThemeModelKey, ThemeModel>()

    private var defaultThemeModel = ThemeModel()

    fun removeThemeModel(key: ThemeModelKey) {
        themeModelMap.remove(key)
    }

    fun putThemeModel(key: ThemeModelKey, themeModel: ThemeModel) {
        themeModelMap[key] = themeModel
    }

    fun getThemeModel(key: ThemeModelKey): ThemeModel {
        return themeModelMap[key] ?: defaultThemeModel
    }

    fun getSupportedThemeModels() : Map<ThemeModelKey, ThemeModel> = themeModelMap

    fun setDefaultThemeModel(themeModel: ThemeModel) {
        defaultThemeModel = themeModel
    }
}