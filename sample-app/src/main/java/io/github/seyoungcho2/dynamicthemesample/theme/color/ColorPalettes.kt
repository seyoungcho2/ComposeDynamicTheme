package io.github.seyoungcho2.dynamicthemesample.theme.color

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object ColorPalettes {
    val LightColorPalette = lightColors(
        surface = Color.White,
        onSurface = Color.Black,

        background = Color.White,
        onBackground = Color.Black,

        secondary = ThemeColor.LIGHT_PASTEL_PURPLE,
        onSecondary = Color.White,

        primary = ThemeColor.PASTEL_PURPLE,
        onPrimary = Color.White,
        primaryVariant = ThemeColor.PASTEL_PURPLE,
        error = ThemeColor.ERROR,
        onError = Color.White
    )

    val DarkColorPalette = darkColors(
        surface = Color.Black,
        onSurface = ThemeColor.WHITE_SMOKE,

        background = ThemeColor.CUSTOM_BLACK50,
        onBackground = ThemeColor.WHITE_SMOKE,

        secondary = ThemeColor.CUSTOM_BLACK80,
        onSecondary = ThemeColor.WHITE_SMOKE,

        primary = ThemeColor.LIGHT_GRAY,
        onPrimary = ThemeColor.CUSTOM_BLACK,
        primaryVariant = ThemeColor.LIGHT_GRAY,
        error = ThemeColor.ERROR,
        onError = Color.White
    )

    val PinkColorPalette = lightColors(
        surface = ThemeColor.DARK_PINK,
        onSurface = Color.White,

        background = ThemeColor.LIGHT_PINK,
        onBackground = Color.White,

        secondary = ThemeColor.PINK,
        onSecondary = Color.White,

        primary = ThemeColor.PRIMARY_PINK,
        onPrimary = Color.White,
        primaryVariant = ThemeColor.PRIMARY_PINK,

        error = ThemeColor.ERROR,
        onError = Color.White
    )

    val BlueColorPalette = lightColors(
        surface = ThemeColor.DARK_BLUE,
        onSurface = Color.White,

        background = ThemeColor.LIGHT_BLUE,
        onBackground = Color.White,

        secondary = ThemeColor.BLUE,
        onSecondary = Color.White,

        primary = ThemeColor.PRIMARY_BLUE,
        onPrimary = Color.White,
        primaryVariant = ThemeColor.PRIMARY_BLUE,

        error = ThemeColor.ERROR,
        onError = Color.White
    )
}