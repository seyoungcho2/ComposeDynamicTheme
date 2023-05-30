package io.github.seyoungcho2.dynamictheme.material3.model.predefine.purple

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import io.github.seyoungcho2.dynamictheme.material3.model.ColorPalette

object PurpleTheme {
    private val md_theme_dark_primary = Color(0xFFCEBDFF)
    private val md_theme_dark_onPrimary = Color(0xFF361F73)
    private val md_theme_dark_primaryContainer = Color(0xFF4D388B)
    private val md_theme_dark_onPrimaryContainer = Color(0xFFE8DDFF)
    private val md_theme_dark_secondary = Color(0xFFCBC3DC)
    private val md_theme_dark_onSecondary = Color(0xFF322E41)
    private val md_theme_dark_secondaryContainer = Color(0xFF494458)
    private val md_theme_dark_onSecondaryContainer = Color(0xFFE7DEF8)
    private val md_theme_dark_tertiary = Color(0xFFCBBEFF)
    private val md_theme_dark_onTertiary = Color(0xFF332074)
    private val md_theme_dark_tertiaryContainer = Color(0xFF4A398C)
    private val md_theme_dark_onTertiaryContainer = Color(0xFFE7DEFF)
    private val md_theme_dark_error = Color(0xFFFFB4AB)
    private val md_theme_dark_errorContainer = Color(0xFF93000A)
    private val md_theme_dark_onError = Color(0xFF690005)
    private val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
    private val md_theme_dark_background = Color(0xFF2B0052)
    private val md_theme_dark_onBackground = Color(0xFFEFDBFF)
    private val md_theme_dark_surface = Color(0xFF2B0052)
    private val md_theme_dark_onSurface = Color(0xFFEFDBFF)
    private val md_theme_dark_surfaceVariant = Color(0xFF48454E)
    private val md_theme_dark_onSurfaceVariant = Color(0xFFCAC4CF)
    private val md_theme_dark_outline = Color(0xFF938F99)
    private val md_theme_dark_inverseOnSurface = Color(0xFF2B0052)
    private val md_theme_dark_inverseSurface = Color(0xFFEFDBFF)
    private val md_theme_dark_inversePrimary = Color(0xFF6550A5)
    private val md_theme_dark_shadow = Color(0xFF000000)
    private val md_theme_dark_surfaceTint = Color(0xFFCEBDFF)
    private val md_theme_dark_outlineVariant = Color(0xFF48454E)
    private val md_theme_dark_scrim = Color(0xFF000000)

    private val PurpleColorScheme = darkColorScheme(
        primary = md_theme_dark_primary,
        onPrimary = md_theme_dark_onPrimary,
        primaryContainer = md_theme_dark_primaryContainer,
        onPrimaryContainer = md_theme_dark_onPrimaryContainer,
        secondary = md_theme_dark_secondary,
        onSecondary = md_theme_dark_onSecondary,
        secondaryContainer = md_theme_dark_secondaryContainer,
        onSecondaryContainer = md_theme_dark_onSecondaryContainer,
        tertiary = md_theme_dark_tertiary,
        onTertiary = md_theme_dark_onTertiary,
        tertiaryContainer = md_theme_dark_tertiaryContainer,
        onTertiaryContainer = md_theme_dark_onTertiaryContainer,
        error = md_theme_dark_error,
        errorContainer = md_theme_dark_errorContainer,
        onError = md_theme_dark_onError,
        onErrorContainer = md_theme_dark_onErrorContainer,
        background = md_theme_dark_background,
        onBackground = md_theme_dark_onBackground,
        surface = md_theme_dark_surface,
        onSurface = md_theme_dark_onSurface,
        surfaceVariant = md_theme_dark_surfaceVariant,
        onSurfaceVariant = md_theme_dark_onSurfaceVariant,
        outline = md_theme_dark_outline,
        inverseOnSurface = md_theme_dark_inverseOnSurface,
        inverseSurface = md_theme_dark_inverseSurface,
        inversePrimary = md_theme_dark_inversePrimary,
        surfaceTint = md_theme_dark_surfaceTint,
        outlineVariant = md_theme_dark_outlineVariant,
        scrim = md_theme_dark_scrim,
    )

    internal val ColorPalette = ColorPalette(
        lightModeColors = PurpleColorScheme,
        darkModeColors = PurpleColorScheme
    )
}