package io.github.seyoungcho2.dynamictheme.material3.model.predefine.white

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import io.github.seyoungcho2.dynamictheme.material3.model.ColorPalette

object WhiteTheme {
    private val md_theme_light_primary = Color(0xFF2F51D5)
    private val md_theme_light_onPrimary = Color(0xFFFFFFFF)
    private val md_theme_light_primaryContainer = Color(0xFFDDE1FF)
    private val md_theme_light_onPrimaryContainer = Color(0xFF001356)
    private val md_theme_light_secondary = Color(0xFF984061)
    private val md_theme_light_onSecondary = Color(0xFFFFFFFF)
    private val md_theme_light_secondaryContainer = Color(0xFFFFD9E2)
    private val md_theme_light_onSecondaryContainer = Color(0xFF3E001E)
    private val md_theme_light_tertiary = Color(0xFF7742B6)
    private val md_theme_light_onTertiary = Color(0xFFFFFFFF)
    private val md_theme_light_tertiaryContainer = Color(0xFFEEDBFF)
    private val md_theme_light_onTertiaryContainer = Color(0xFF2A0053)
    private val md_theme_light_error = Color(0xFFBA1A1A)
    private val md_theme_light_errorContainer = Color(0xFFFFDAD6)
    private val md_theme_light_onError = Color(0xFFFFFFFF)
    private val md_theme_light_onErrorContainer = Color(0xFF410002)
    private val md_theme_light_background = Color(0xFFF8FDFF)
    private val md_theme_light_onBackground = Color(0xFF001F25)
    private val md_theme_light_surface = Color(0xFFF8FDFF)
    private val md_theme_light_onSurface = Color(0xFF001F25)
    private val md_theme_light_surfaceVariant = Color(0xFFE2E1EC)
    private val md_theme_light_onSurfaceVariant = Color(0xFF45464F)
    private val md_theme_light_outline = Color(0xFF767680)
    private val md_theme_light_inverseOnSurface = Color(0xFFD6F6FF)
    private val md_theme_light_inverseSurface = Color(0xFF00363F)
    private val md_theme_light_inversePrimary = Color(0xFFB9C3FF)
    private val md_theme_light_shadow = Color(0xFF000000)
    private val md_theme_light_surfaceTint = Color(0xFF2F51D5)
    private val md_theme_light_outlineVariant = Color(0xFFC6C5D0)
    private val md_theme_light_scrim = Color(0xFF000000)

    private val WhiteColorScheme = lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        primaryContainer = md_theme_light_primaryContainer,
        onPrimaryContainer = md_theme_light_onPrimaryContainer,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        secondaryContainer = md_theme_light_secondaryContainer,
        onSecondaryContainer = md_theme_light_onSecondaryContainer,
        tertiary = md_theme_light_tertiary,
        onTertiary = md_theme_light_onTertiary,
        tertiaryContainer = md_theme_light_tertiaryContainer,
        onTertiaryContainer = md_theme_light_onTertiaryContainer,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        onError = md_theme_light_onError,
        onErrorContainer = md_theme_light_onErrorContainer,
        background = md_theme_light_background,
        onBackground = md_theme_light_onBackground,
        surface = md_theme_light_surface,
        onSurface = md_theme_light_onSurface,
        surfaceVariant = md_theme_light_surfaceVariant,
        onSurfaceVariant = md_theme_light_onSurfaceVariant,
        outline = md_theme_light_outline,
        inverseOnSurface = md_theme_light_inverseOnSurface,
        inverseSurface = md_theme_light_inverseSurface,
        inversePrimary = md_theme_light_inversePrimary,
        surfaceTint = md_theme_light_surfaceTint,
        outlineVariant = md_theme_light_outlineVariant,
        scrim = md_theme_light_scrim,
    )

    val ColorPalette: ColorPalette = ColorPalette(
        lightModeColors = WhiteColorScheme,
        darkModeColors = WhiteColorScheme
    )
}