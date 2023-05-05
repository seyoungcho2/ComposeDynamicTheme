package com.simplit.dynamictheme.provider

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.simplit.dynamictheme.data.DynamicThemeRepository
import com.simplit.dynamictheme.model.ThemeModel

class DynamicThemeProvider internal constructor(
    private val dynamicThemeRepository: DynamicThemeRepository
) {
    @Composable
    fun ProvidesTheme(
        themeModel: ThemeModel,
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colors = if (isSystemInDarkTheme()) {
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