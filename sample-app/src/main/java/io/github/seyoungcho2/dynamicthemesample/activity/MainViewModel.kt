package io.github.seyoungcho2.dynamicthemesample.activity

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.github.seyoungcho2.dynamictheme.DynamicThemeService
import io.github.seyoungcho2.dynamictheme.model.ThemeModel
import io.github.seyoungcho2.dynamictheme.model.ThemeModelKey
import io.github.seyoungcho2.dynamicthemesample.DynamicThemeApp
import io.github.seyoungcho2.dynamicthemesample.theme.name.ThemeNameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val dynamicThemeService: DynamicThemeService,
    private val themeNameRepository: ThemeNameRepository = ThemeNameRepository()
) : ViewModel() {
    private val ioDispatcher = Dispatchers.IO

    private val _supportedThemes : MutableStateFlow<Map<ThemeModelKey, ThemeModel>> = MutableStateFlow(dynamicThemeService.getRegisteredThemeModels())
    val supportedThemes : StateFlow<Map<ThemeModelKey, ThemeModel>> = _supportedThemes

    val currentThemeModel = dynamicThemeService.currentThemeModel
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIME_OUT_MILLIS),
            initialValue = dynamicThemeService.getDefaultThemeModel()
        )

    @Composable
    fun ProvidesTheme(content: @Composable () -> Unit) = dynamicThemeService.ProvidesTheme(content)

    fun setCurrentThemeModel(themeModelKey: ThemeModelKey) {
        viewModelScope.launch(ioDispatcher) {
            dynamicThemeService.setCurrentThemeModel(themeModelKey)
        }
    }

    fun getName(themeModelKey: ThemeModelKey) : String {
        return themeNameRepository.getThemeName(themeModelKey)
    }

    companion object {
        private const val TIME_OUT_MILLIS = 1000L

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val dynamicThemeFacade = (this[APPLICATION_KEY] as DynamicThemeApp).compositionRoot.dynamicThemeService
                MainViewModel(
                    savedStateHandle = savedStateHandle,
                    dynamicThemeService = dynamicThemeFacade
                )
            }
        }
    }
}