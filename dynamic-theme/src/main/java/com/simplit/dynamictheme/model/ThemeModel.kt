package com.simplit.dynamictheme.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.ui.unit.dp

data class ThemeModel(
    val colorPalette: ColorPalette = ColorPalette(),
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
)