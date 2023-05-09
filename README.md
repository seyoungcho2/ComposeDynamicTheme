![Title-2](https://user-images.githubusercontent.com/59521473/237021425-d3289ba1-bff3-495e-922d-91bdc0505b5a.png)

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
</p>

# What's Dynamic Theme
Dynamic Theme is Material Design based Theme Management System for Android Jetpack Compose. Up until now, changing the theme on Android has been a very difficult task. Dynamic Theme is made to make Android's theme management easy.
<br><br>
<p align="center">
    <img src="https://user-images.githubusercontent.com/59521473/237029773-3d173741-2bfd-47f9-82fe-6f7f6a6c561e.gif" alt="animated" />
</p>

<br><br>

# Download

## Gradle
```gradle
dependencies {
    implementation "com.github.seyoungcho2:dynamictheme:1.0.0"
}
```

<br><br>

# Features
Table of Contents
- [ThemeModelKey](https//github.com/seyoungcho2/ComposeDynamicTheme#thememodelkey)
- [ThemeModel](https//github.com/seyoungcho2/ComposeDynamicTheme#thememodel)
- [Register ThemeModels](https//github.com/seyoungcho2/ComposeDynamicTheme#registerthememodels)



## Easy to register supported themes
```kotlin
DynamicThemeService.getInstance(context).apply {
    registerThemeModel(
        ThemeModelKey.of("Pink"), ThemeModel(
            colorPalette = ColorPalette(
                lightModeColors = ColorPalettes.PinkColorPalette,
                darkModeColors = ColorPalettes.PinkColorPalette,
            ),
            shapes = Shapes.DEFAULT_ROUNDED_SHAPE
        )
    )

    registerThemeModel(
        ThemeModelKey.of("Blue"), ThemeModel(
            colorPalette = ColorPalette(
                lightModeColors = ColorPalettes.BlueColorPalette,
                darkModeColors = ColorPalettes.BlueColorPalette,
            )
        )
    )
}
```

## Multiple theme register also supported 
```kotlin
DynamicThemeService.getInstance(context).apply {
    this.registerThemeModels(ThemeModels.getSupportedThemeModels())
}

fun getSupportedThemeModels(): Map<ThemeModelKey, ThemeModel> = mapOf(
    THEME_MODEL_KEY_DEFAULT to THEME_MODEL_DEFAULT,
    THEME_MODEL_KEY_BLACK to THEME_MODEL_BLACK,
    THEME_MODEL_KEY_PINK to THEME_MODEL_PINK,
    THEME_MODEL_KEY_BLUE to THEME_MODEL_BLUE,
    THEME_MODEL_KEY_WHITE to THEME_MODEL_WHITE
)
```


<br>

## Download
