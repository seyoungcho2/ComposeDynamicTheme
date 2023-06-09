package io.github.seyoungcho2.dynamictheme.model

import androidx.compose.material.Shapes
import androidx.compose.material.Typography

data class ThemeModel(
    val colorPalette: ColorPalette = ColorPalette(),
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
)