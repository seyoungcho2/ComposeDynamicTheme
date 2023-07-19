![Title-2](https://user-images.githubusercontent.com/59521473/237021425-d3289ba1-bff3-495e-922d-91bdc0505b5a.png)

<p align="center">
  <a href="https://devlibrary.withgoogle.com/products/android/repos/seyoungcho2-ComposeDynamicTheme"><img alt="API" src="https://img.shields.io/badge/Google%20DevLibrary-Seyoung%20Cho-orange?style=flat&logo=android"/></a>
  <a href="https://github.com/jetpack-compose/jetpack-compose-awesome"><img alt="API" src="https://img.shields.io/badge/Jetpack%20Compose%20Awesome-Compose%20Dynamic%20Theme-green?style=flat&logo=jetpackcompose"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
</p>

<br>

### 🚀 Introduced in Android Dev Notes [Link](https://twitter.com/androiddevnotes/status/1664061139569766400)
### Next Roadmap is to support change color on status bar

<br>

# What's Dynamic Theme
Dynamic Theme is a Material Design-based Theme Management System for Android Jetpack Compose. Up until now, changing the theme on Android has been a very difficult task. Dynamic Theme was created to make Android's theme management easy. Theming can be applied by simply adding 'ProvidesTheme' to the top-level declaration in Jetpack Compose.
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicThemeService.get().ProvidesTheme {
                // Add Compose Functions
            }
        }
    }
}
```
<br>

Since this theme management system is based on Material Designs, knowledge of the Material Design System is required to use this library.
- [Material2 Design System](https://m2.material.io/design/introduction)
- [Material3 Design System](https://m3.material.io/styles)

<br>

# Preview
<br><br>
<p align="center">
    <img src="https://github.com/seyoungcho2/ComposeDynamicTheme/assets/59521473/2c6119cb-6b1b-43db-b40c-8522dad372d0" alt="animated" />
</p>


<br><br>

# Downloads
## Maven Central
Material2 : [![Maven Central](https://img.shields.io/maven-central/v/io.github.seyoungcho2/dynamic-theme-compose.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.seyoungcho2/dynamic-theme-compose)<br>
Material3 : [![Maven Central](https://img.shields.io/maven-central/v/io.github.seyoungcho2/dynamic-theme-compose-material3.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.seyoungcho2/dynamic-theme-compose-material3)<br>

# Getting Started
Add the mavenCentral() on project level(root level) build.gradle file:
```gradle
allprojects {
    repositories {
        mavenCentral()
    }
}
```

Add dependency on module level build.gradle file:
### build.gradle
```gradle
dependencies {
    // Dynamic Theme support for Material2
    implementation "io.github.seyoungcho2:dynamic-theme-compose:0.0.3"
    
    // Dynamic Theme support for Material3
    implementation "io.github.seyoungcho2:dynamic-theme-compose-material3:0.0.3"
}
```
If using build.gradle.kts
### build.gradle.kts
```kotlin
dependencies {
    // Dynamic Theme support for Material2
    implementation("io.github.seyoungcho2:dynamic-theme-compose:0.0.3")
        
    // Dynamic Theme support for Material3
    implementation("io.github.seyoungcho2:dynamic-theme-compose-material3:0.0.3")
}
```


<br><br>

# Features
Table of Contents
- [ThemeModelKey](https://github.com/seyoungcho2/ComposeDynamicTheme#thememodelkey)
- [ThemeModel](https://github.com/seyoungcho2/ComposeDynamicTheme#thememodel)
- [How to use DynamicThemeService](https://github.com/seyoungcho2/ComposeDynamicTheme#how-to-use-dynamicthemeservice)


## ThemeModelKey
The ThemeModelKey is used to register the ThemeModel and access the registered ThemeModel.
- ThemeModelKey can be declared by using the function on ThemeModelKey
```kotlin
val THEME_MODEL_KEY_BLUE = ThemeModelKey.of("Blue")
```
- ThemeModelKey.Default is predefined for the default theme. If the current theme is not set, then ThemeModelKey.Default is used to retrieve the ThemeModel. Alternatively, you can also access the default ThemeModel using it.
```kotlin
DynamicThemeService.get().getThemeModel(ThemeModelKey.Default)
```
<br><br>

## ThemeModel
The ThemeModel is a data class for saving themes. It contains three parameters:
- ColorPalette: Light mode and dark mode color combinations for the theme.
- Typography: Configurations of typography for the theme.
- Shapes: Shape configurations for the theme."
```kotlin
data class ThemeModel(
    val colorPalette: ColorPalette = ColorPalette(),
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes()
)
```

ThemeModel looks same on Material2 and Material3, but inside ThemeModel is little bit different. It's caused by the classes used in Material2 and Material3 are different. <br>
<br>
Check what your project is using and make ThemeModel

<br>

## Material2 ThemeModel
Material2 ThemeModel consists of three parameters: ColorPalette, Typography, Shapes. <br><br>

### ColorPalette
The ColorPalette contains two parameters: 'lightModeColors' for the Light Theme and 'darkModeColors' for the Dark Theme. When the device is set to dark mode on system, the darkModeColors are automatically used.
```
data class ColorPalette(
    val lightModeColors: Colors = LightModeColorPalette,
    val darkModeColors: Colors = DarkModeColorPalette
)
```

Colors class is Material2 class which consist of primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight variables. You can find more about color system on [Material2 Color System](https://m2.material.io/design/color/the-color-system.html), [Material2 Color Document](https://developer.android.com/reference/kotlin/androidx/compose/material/Colors)


### Typography
Typography contains design data for characters. This is also part of Material2 Typography System. You will probably see familiar things like h1, h2, h3, subtitle1, subtitle2, body1, body2. Which are used to build heirarchy of characters. See [Material2 Typography](https://developer.android.com/reference/kotlin/androidx/compose/material/Typography)

### Shapes
See [Material2 Shapes](https://m2.material.io/design/shape/applying-shape-to-ui.html) document

<br><br>

## Material3 ThemeModel
Material3 ThemeModel consists of three parameters: ColorPalette, Typography, Shapes. <br><br>

### ColorPalette
The ColorPalette contains two parameters: 'lightModeColors' for the Light Theme and 'darkModeColors' for the Dark Theme. When the device is set to dark mode on system, the darkModeColors are automatically used.
```
data class ColorPalette(
    val lightModeColors: ColorScheme = DefaultLightColorPalette,
    val darkModeColors: ColorScheme = DefaultDarkColorPalette
)
```

ColorScheme class is Material3 class which consist of 29 colors which are used for coloring the application. You can find more about color system on [Material3 Color System](https://m3.material.io/styles/color/overview), [Material3 Color Document](https://developer.android.com/reference/kotlin/androidx/compose/material3/ColorScheme)


### Typography
Typography contains design data for characters. This is also part of Material3 Typography System. Material3 typography enables us to fine-tune control for designing texts. See [Material3 Typography](https://m3.material.io/styles/typography/overview)

### Shapes
See [Material3 Shapes](https://m3.material.io/styles/shape/overview) document

<br><br>



## How to use DynamicThemeService
DynamicThemeService is initialized as a singleton object by using DynamicThemeService.init(applicationContext). You must initalize DynamicThemeService to use it.
```kotlin
class DynamicThemeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicThemeService.init(applicationContext)
    }
}
```

After initialized DynamicThemeService can be accessed by using DynamicThemeService.get(). <br><br>
```kotlin
val dynamicThemeService: DynamicThemeService = DynamicThemeService.get()
```

### DynamicThemeService features
Dynamic has following features:
- Register Themes
- Get Registered Themes
- Set Current Theme
- Get Current Theme
- Provide Theme Composable with Current Theme
- Provide Theme Composable with ThemeModel
- How access theme variables on Composable

<br>

### Register Themes
Registering both single and multiple theme supported. Default theme can also be changed.
#### Single Theme Registration
```kotlin
DynamicThemeService.get().apply {
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
DynamicThemeService.get().apply {
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
DynamicThemeService.get().apply {
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
DynamicThemeService.get().getThemeModel(themeModelKey)
```

#### Get All Registered Themes
```kotlin
val registeredThemes: Map<ThemeModelKey, ThemeModel> = DynamicThemeService.get().getRegisteredThemes()
```

<br><br>

### Set Current Theme
```kotlin
suspend fun setCurrentTheme(themeModelKey: ThemeModelKey){
    DynamicThemeService.get().setCurrentTheme(themeModelKey)
}
```

<br><br>

### Get Current Theme
#### Get Current Theme
```kotlin
val currentThemeModel: ThemeModel = async { DynamicThemeService.get().getCurrentThemeModel() }.await()
```

#### Get Current Theme with Reactively with Flow
```kotlin
val currentThemeModelFlow: Flow<ThemeModel> = DynamicThemeService.get().currentThemeModel
```

<br><br>

### Provide Current Theme Composable
```kotlin
DynamicThemeService.get().ProvidesTheme {
    // Write Composable Functions
}
```

<br><br>

### Provide Theme Composable with ThemeModel
```kotlin
DynamicThemeService.get().ProvidesTheme(themeModel) {
    // Write Composable Functions
}
```

<br><br>

### How to access theme variables
#### Accessing theme variables in Material2
- Accessing color can be done by using 'MaterialTheme.colors.[Color Name]' 
```kotlin
Box(
    modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
)
```
- Accessing typography can be done by using 'MaterialTheme.typography.[Typography Name]' 
```kotlin
Text(
    text = "Themes",
    style = MaterialTheme.typography.h5
)
```
- Accessing shapes can be done by using 'MaterialTheme.shapes.[Shape Name]'
```kotlin
Box(
    modifier = Modifier
        .fillMaxSize()
        .clip(MaterialTheme.shapes.medium)
)
```

#### Accessing theme variables in Material3
- Accessing color can be done by using 'MaterialTheme.colorScheme.[Color Name]' 
```kotlin
Box(
    modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
)
```
- Accessing typography can be done by using 'MaterialTheme.typography.[Typography Name]' 
```kotlin
Text(
    text = "Themes",
    style = MaterialTheme.typography.bodyLarge
)
```
- Accessing shapes can be done by using 'MaterialTheme.shapes.[Shape Name]'
```kotlin
Card(
    modifier = modifier,
    shape = MaterialTheme.shapes.extraLarge
)
```

<br><br>


## Find this repository useful?👍
- Support it by making star⭐! <br> You can see __[stargazers](https://github.com/seyoungcho2/ComposeDynamicTheme/stargazers)__ here.<br>
- Also, __[follow me](https://github.com/seyoungcho2)__ on GitHub for further updates 

<br>

# License
```xml
Designed and developed by 2023 seyoungcho2 (Seyoung Cho)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
