package com.simplit.dynamictheme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.simplit.dynamictheme.data.DynamicThemeRepository
import com.simplit.dynamictheme.data.DynamicThemeRepositoryImpl
import com.simplit.dynamictheme.data.ThemeModelMapManager
import com.simplit.dynamictheme.model.ThemeModel
import com.simplit.dynamictheme.model.ThemeModelKey
import com.simplit.dynamictheme.provider.DynamicThemeProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class DynamicThemeFacade(
    context: Context
) {
    private val themeModelMapManager: ThemeModelMapManager = ThemeModelMapManager()
    private val dynamicThemeRepository: DynamicThemeRepository =
        DynamicThemeRepositoryImpl(context, themeModelMapManager)
    private val dynamicThemeProvider = DynamicThemeProvider()

    /**
     * Provides Theme with Currently Set ThemeModel
     */
    @Composable
    fun ProvidesTheme(
        content: @Composable () -> Unit
    ) {
        val themeModel by dynamicThemeRepository.currentThemeModel.collectAsState(themeModelMapManager.getDefaultThemeModel())
        dynamicThemeProvider.ProvidesTheme(themeModel, content)
    }

    /**
     * Provides Theme with [themeModel] passed with parameter
     */
    @Composable
    fun ProvidesTheme(
        themeModel: ThemeModel,
        content: @Composable () -> Unit
    ) {
        dynamicThemeProvider.ProvidesTheme(themeModel, content)
    }

    /**
     * Register ThemeModel
     * [key] : ThemeModel can be access key
     * [themeModel] : Customizable ThemeModel
     */
    fun putThemeModel(key: ThemeModelKey, themeModel: ThemeModel) {
        themeModelMapManager.putThemeModel(key, themeModel)
    }

    /**
     * Get ThemeModel by [key]
     */
    fun getThemeModel(key: ThemeModelKey): ThemeModel {
        return themeModelMapManager.getThemeModel(key)
    }

    /**
     * Get registered ThemeModels
     */
    fun getSupportedThemeModels(): Map<ThemeModelKey, ThemeModel> {
        return themeModelMapManager.getSupportedThemeModels()
    }

    /**
     * Remove registered ThemeModel by using [key]
     */
    fun removeThemeModel(key: ThemeModelKey) {
        themeModelMapManager.removeThemeModel(key)
    }

    /**
     * Get currently set ThemeModel
     */
    suspend fun getCurrentThemeModel(): ThemeModel {
        return dynamicThemeRepository.currentThemeModel.first()
    }

    /**
     * Get currently set ThemeModel with [Flow]
     */
    fun getCurrentThemeModelFlow(): Flow<ThemeModel> {
        return dynamicThemeRepository.currentThemeModel
    }

    /**
     * Set current theme model which will be used on ui
     */
    suspend fun setCurrentThemeModel(themeModelKey: ThemeModelKey) {
        dynamicThemeRepository.setCurrentThemeModel(themeModelKey)
    }
}