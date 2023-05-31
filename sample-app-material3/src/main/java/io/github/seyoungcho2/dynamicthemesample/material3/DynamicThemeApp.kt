package io.github.seyoungcho2.dynamicthemesample.material3

import android.app.Application
import io.github.seyoungcho2.dynamictheme.material3.DynamicThemeService
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.PredefinedThemeModel
import io.github.seyoungcho2.dynamicthemesample.material3.theme.ThemeModels

class DynamicThemeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicThemeService.init(applicationContext).apply {
            registerThemeModels(
                mapOf(
                    ThemeModels.THEME_MODEL_KEY_WHITE to PredefinedThemeModel.WHITE_THEME,
                    ThemeModels.THEME_MODEL_KEY_BLACK to PredefinedThemeModel.BLACK_THEME,
                    ThemeModels.THEME_MODEL_KEY_NAVY to PredefinedThemeModel.NAVY_THEME,
                    ThemeModels.THEME_MODEL_KEY_PURPLE to PredefinedThemeModel.PURPLE_THEME,
                    ThemeModels.THEME_MODEL_KEY_WHITE_PURPLE to PredefinedThemeModel.WHITE_PURPLE_THEME,
                    ThemeModels.THEME_MODEL_KEY_WHITE_BLUE to PredefinedThemeModel.WHITE_BLUE_THEME,
                )
            )
        }
    }
}