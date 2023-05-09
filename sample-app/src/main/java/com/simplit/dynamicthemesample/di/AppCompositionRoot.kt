package com.simplit.dynamicthemesample.di

import android.content.Context
import com.simplit.dynamicthemesample.DynamicThemeService
import com.simplit.dynamicthemesample.theme.ThemeModels

class AppCompositionRoot(context: Context) {
    val dynamicThemeService = DynamicThemeService.getInstance(context).apply {
        this.registerThemeModels(ThemeModels.getSupportedThemeModels())
    }
}