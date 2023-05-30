package io.github.seyoungcho2.dynamictheme.material3.model.predefine

import io.github.seyoungcho2.dynamictheme.material3.model.ThemeModel
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.black.BlackTheme
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.navy.NavyTheme
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.purple.PurpleTheme
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.whitepurple.WhitePurpleTheme
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.white.WhiteTheme
import io.github.seyoungcho2.dynamictheme.material3.model.predefine.whiteblue.WhiteBlueTheme

object PredefinedThemeModel {
    val WHITE_THEME = ThemeModel(WhiteTheme.ColorPalette)
    val WHITE_BLUE_THEME = ThemeModel(WhiteBlueTheme.ColorPalette)
    val WHITE_PURPLE_THEME = ThemeModel(WhitePurpleTheme.ColorPalette)
    val BLACK_THEME = ThemeModel(BlackTheme.ColorPalette)
    val PURPLE_THEME = ThemeModel(PurpleTheme.ColorPalette)
    val NAVY_THEME = ThemeModel(NavyTheme.ColorPalette)
}