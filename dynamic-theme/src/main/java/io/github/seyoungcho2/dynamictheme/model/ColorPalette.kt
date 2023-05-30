package io.github.seyoungcho2.dynamictheme.model

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors

data class ColorPalette(
    val lightModeColors: Colors = DefaultLightColorPalette,
    val darkModeColors: Colors = DefaultDarkColorPalette
) {
    companion object {
        internal val DefaultLightColorPalette: Colors = lightColors()
        internal val DefaultDarkColorPalette: Colors = darkColors()
    }
}
