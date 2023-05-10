package io.github.seyoungcho2.dynamicthemesample.di

import android.content.Context
import io.github.seyoungcho2.dynamictheme.DynamicThemeService
import io.github.seyoungcho2.dynamicthemesample.theme.ThemeModels

class AppCompositionRoot(context: Context) {
    val dynamicThemeService = DynamicThemeService.init(context).apply {
        this.registerThemeModels(ThemeModels.getSupportedThemeModels())
    }
}