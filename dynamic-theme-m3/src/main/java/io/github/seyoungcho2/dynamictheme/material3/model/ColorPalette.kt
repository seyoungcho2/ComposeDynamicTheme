package io.github.seyoungcho2.dynamictheme.material3.model

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

data class ColorPalette(
    val lightModeColors: ColorScheme = DefaultLightColorPalette,
    val darkModeColors: ColorScheme = DefaultDarkColorPalette
) {
    companion object {
        internal val DefaultLightColorPalette: ColorScheme = lightColorScheme()
        internal val DefaultDarkColorPalette: ColorScheme = darkColorScheme()
    }
}
