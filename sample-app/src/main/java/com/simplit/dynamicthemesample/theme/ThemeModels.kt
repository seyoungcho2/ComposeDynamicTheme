package com.simplit.dynamicthemesample.theme

import com.simplit.dynamicthemesample.model.ColorPalette
import com.simplit.dynamicthemesample.model.ThemeModel
import com.simplit.dynamicthemesample.model.ThemeModelKey
import com.simplit.dynamicthemesample.theme.color.ColorPalettes
import com.simplit.dynamicthemesample.theme.shape.Shapes

object ThemeModels {
    val THEME_MODEL_KEY_DEFAULT = ThemeModelKey.Default
    private val THEME_MODEL_DEFAULT = ThemeModel(
        colorPalette = ColorPalette(
            lightModeColors = ColorPalettes.LightColorPalette,
            darkModeColors = ColorPalettes.DarkColorPalette
        ),
        shapes = Shapes.DEFAULT_ROUNDED_SHAPE
    )

    val THEME_MODEL_KEY_WHITE = ThemeModelKey.of("White")
    private val THEME_MODEL_WHITE = ThemeModel(
        colorPalette = ColorPalette(
            lightModeColors = ColorPalettes.LightColorPalette,
            darkModeColors = ColorPalettes.LightColorPalette,
        ),
        shapes = Shapes.DEFAULT_ROUNDED_SHAPE
    )

    val THEME_MODEL_KEY_BLACK = ThemeModelKey.of("Black")
    private val THEME_MODEL_BLACK = ThemeModel(
        colorPalette = ColorPalette(
            lightModeColors = ColorPalettes.DarkColorPalette,
            darkModeColors = ColorPalettes.DarkColorPalette,
        ),
        shapes = Shapes.DEFAULT_ROUNDED_SHAPE
    )

    val THEME_MODEL_KEY_PINK = ThemeModelKey.of("Pink")
    private val THEME_MODEL_PINK = ThemeModel(
        colorPalette = ColorPalette(
            lightModeColors = ColorPalettes.PinkColorPalette,
            darkModeColors = ColorPalettes.PinkColorPalette,
        ),
        shapes = Shapes.DEFAULT_ROUNDED_SHAPE
    )

    val THEME_MODEL_KEY_BLUE = ThemeModelKey.of("Blue")
    private val THEME_MODEL_BLUE = ThemeModel(
        colorPalette = ColorPalette(
            lightModeColors = ColorPalettes.BlueColorPalette,
            darkModeColors = ColorPalettes.BlueColorPalette,
        ),
        shapes = Shapes.DEFAULT_ROUNDED_SHAPE
    )

    fun getSupportedThemeModels(): Map<ThemeModelKey, ThemeModel> = mapOf(
        THEME_MODEL_KEY_DEFAULT to THEME_MODEL_DEFAULT,
        THEME_MODEL_KEY_BLACK to THEME_MODEL_BLACK,
        THEME_MODEL_KEY_PINK to THEME_MODEL_PINK,
        THEME_MODEL_KEY_BLUE to THEME_MODEL_BLUE,
        THEME_MODEL_KEY_WHITE to THEME_MODEL_WHITE
    )
}