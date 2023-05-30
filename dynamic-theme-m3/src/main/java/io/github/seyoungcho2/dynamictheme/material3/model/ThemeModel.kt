package io.github.seyoungcho2.dynamictheme.material3.model

import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography

data class ThemeModel(
    val colorPalette: ColorPalette = ColorPalette(),
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
)