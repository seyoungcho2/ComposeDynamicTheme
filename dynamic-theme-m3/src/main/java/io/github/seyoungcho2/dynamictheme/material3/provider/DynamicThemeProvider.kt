package io.github.seyoungcho2.dynamictheme.material3.provider

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import io.github.seyoungcho2.dynamictheme.material3.model.ThemeModel

internal class DynamicThemeProvider internal constructor() {
    @Composable
    fun ProvidesTheme(
        themeModel: ThemeModel,
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colorScheme = if (isSystemInDarkTheme()) {
                themeModel.colorPalette.darkModeColors
            } else {
                themeModel.colorPalette.lightModeColors
            },
            typography = themeModel.typography,
            shapes = themeModel.shapes,
            content = content
        )
    }
}