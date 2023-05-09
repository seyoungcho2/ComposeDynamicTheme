![Title-2](https://user-images.githubusercontent.com/59521473/237021425-d3289ba1-bff3-495e-922d-91bdc0505b5a.png)

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
</p>

# What's Dynamic Theme
Dynamic Theme is Material Design based Theme Management System for Android Jetpack Compose. Up until now, changing the theme on Android has been a very difficult task. Dynamic Theme was created to make Android's theme management easy. Theming can be applied by just adding ProvidesTheme on the top level declaration on the Jetpack Compose. 
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicThemeService.getInstance(applicationContext).ProvidesTheme {
                // Add Compose Functions
            }
        }
    }
}
```
<br>

Since this theme management system is based on Material2 knowledge on [Material2 Color System](https://m2.material.io/design/color/the-color-system.html) is needed to use this library.
<br><br>
<p align="center">
    <img src="https://user-images.githubusercontent.com/59521473/237029773-3d173741-2bfd-47f9-82fe-6f7f6a6c561e.gif" alt="animated" />
</p>

<br><br>

# Download

## Maven Central
[![Maven Central](https://img.shields.io/maven-central/v/io.github.seyoungcho2/dynamic-theme-compose.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.seyoungcho2/dynamic-theme-compose)<br>


## Gradle
```gradle
dependencies {
    implementation "com.github.seyoungcho2:dynamic-theme-compose:0.0.1"
}
```
## Gradle.kts
```kotlin
dependencies {
    implementation("io.github.seyoungcho2:dynamic-theme-compose:0.0.1")
}
```

<br><br>

# Features
Table of Contents
- [ThemeModelKey](https://github.com/seyoungcho2/ComposeDynamicTheme#thememodelkey)
- [ThemeModel](https://github.com/seyoungcho2/ComposeDynamicTheme#thememodel)
- [How to use DynamicThemeService](https://github.com/seyoungcho2/ComposeDynamicTheme#how-to-use-dynamicthemeservice)


## ThemeModelKey
ThemeModelKey is a key to register ThemeModel and access registered ThemeModel.
- ThemeModelKey can be declared by using of function on ThemeModelKey
```kotlin
val THEME_MODEL_KEY_BLUE = ThemeModelKey.of("Blue")
```
- ThemeModelKey.Default is predefined for default theme. If current theme is not set then ThemeModelKey.Default is used get ThemeModel. Or you can also access default ThemeModel using it.
```kotlin
DynamicThemeService.getInstance(context).getThemeModel(ThemeModelKey.Default)
```
<br><br>

## ThemeModel
ThemeModel is data class for saving Themes. ThemeModel contains three parameters. 
- ColorPalette: Color combinations for Theme. 
- Typography: Configurations of typographies for Theme.
- Shapes: Shape configuration for Theme
```kotlin
data class ThemeModel(
    val colorPalette: ColorPalette = ColorPalette(),
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
)
```
I will briefly explain about this three parameters on following sections but you don't need to define all of them. All you have to do is set up a small part that you need to customize like below.
```kotlin
val THEME_MODEL_KEY_BLUE = ThemeModelKey.of("Blue")
private val THEME_MODEL_BLUE = ThemeModel(
    colorPalette = ColorPalette(
        lightModeColors = ColorPalettes.BlueColorPalette,
        darkModeColors = ColorPalettes.BlueColorPalette,
    )
)
```

### ColorPalette
ColorPalette contains two parameters one is for Light Theme and the other is for Dark Theme. When device is set to night mode then darkModeColors is automatically used.
```
data class ColorPalette(
    val lightModeColors: Colors = DefaultLightColorPalette,
    val darkModeColors: Colors = lightModeColors
)
```
Colors class is Material2 class which consist of primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight variables. You can find more about color system on [Material2 Color System](https://m2.material.io/design/color/the-color-system.html), [Material2 Color Document](https://developer.android.com/reference/kotlin/androidx/compose/material/Colors)


### Typography
Typography contains design data for characters. This is also part of Material2 Typography System. You will probably see familiar things like h1, h2, h3, subtitle1, subtitle2, body1, body2. Which are used to build heirarchy of characters. See [Material2 Typography](https://developer.android.com/reference/kotlin/androidx/compose/material/Typography)

### Shapes
See [Material2 Shapes](https://m2.material.io/design/shape/applying-shape-to-ui.html) document

<br><br>

## How to use DynamicThemeService
DynamicThemeService is a singleton object which has following responsibilities
- Register Themes
- Get Registered Themes
- Set Current Theme
- Get Current Theme
- Provide Theme Composable with Current Theme
- Provide Theme Composable with ThemeModel

### Register Themes
Registering both single and multiple theme supported. Default theme can also be changed.
#### Single Theme Registration
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

#### Multiple Theme Registration 
```kotlin
DynamicThemeService.getInstance(context).apply {
    registerThemeModels(ThemeModels.getSupportedThemeModels())
}

fun getSupportedThemeModels(): Map<ThemeModelKey, ThemeModel> = mapOf(
    THEME_MODEL_KEY_DEFAULT to THEME_MODEL_DEFAULT,
    THEME_MODEL_KEY_BLACK to THEME_MODEL_BLACK,
    THEME_MODEL_KEY_PINK to THEME_MODEL_PINK,
    THEME_MODEL_KEY_BLUE to THEME_MODEL_BLUE,
    THEME_MODEL_KEY_WHITE to THEME_MODEL_WHITE
)
```

#### Register Default Theme
```kotlin
DynamicThemeService.getInstance(context).apply {
    registerThemeModel(
        ThemeModelKey.Default, ThemeModel(
            colorPalette = ColorPalette(
                lightModeColors = ColorPalettes.BlueColorPalette,
                darkModeColors = ColorPalettes.BlueColorPalette,
            )
        )
    )
}
```
<br><br>

### Get Registered Themes
#### Get Single Registered Theme
```kotlin
DynamicThemeService.getInstance(applicationContext).getThemeModel(themeModelKey)
```

#### Get All Registered Themes
```kotlin
val registeredThemes: Map<ThemeModelKey, ThemeModel> = DynamicThemeService.getInstance(applicationContext).getRegisteredThemes()
```

<br><br>

### Set Current Theme
```kotlin
suspend fun setCurrentTheme(themeModelKey: ThemeModelKey){
    DynamicThemeService.getInstance(applicationContext).setCurrentTheme(themeModelKey)
}
```

<br><br>

### Get Current Theme
#### Get Current Theme
```kotlin
val currentThemeModel: ThemeModel = async { DynamicThemeService.getInstance(applicationContext).getCurrentThemeModel() }.await()
```

#### Get Current Theme with Reactively with Flow
```kotlin
val currentThemeModelFlow: Flow<ThemeModel> = DynamicThemeService.getInstance(applicationContext).currentThemeModel
```

<br><br>

### Provide Current Theme Composable
```kotlin
DynamicThemeService.getInstance(applicationContext).ProvidesTheme {
    // Write Composable Functions
}
```

<br><br>

### Provide Theme Composable with ThemeModel
```kotlin
DynamicThemeService.getInstance(applicationContext).ProvidesTheme(themeModel) {
    // Write Composable Functions
}
```


