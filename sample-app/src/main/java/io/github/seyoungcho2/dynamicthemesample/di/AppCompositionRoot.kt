package io.github.seyoungcho2.dynamicthemesample.di

import android.content.Context
import com.github.seyoungcho2.dynamictheme.DynamicThemeService
import io.github.seyoungcho2.dynamicthemesample.theme.ThemeModels

class AppCompositionRoot(context: Context) {
    val dynamicThemeService = DynamicThemeService.getInstance(context).apply {
        this.registerThemeModels(ThemeModels.getSupportedThemeModels())
    }
}