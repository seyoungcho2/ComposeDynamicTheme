package com.simplit.dynamictheme

import android.app.Application
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
import java.lang.IllegalArgumentException

private class DynamicThemeServiceImpl internal constructor(
    context: Context
) : DynamicThemeService {
    private val themeModelMapManager: ThemeModelMapManager = ThemeModelMapManager()
    private val dynamicThemeRepository: DynamicThemeRepository =
        DynamicThemeRepositoryImpl(context, themeModelMapManager)
    private val dynamicThemeProvider = DynamicThemeProvider()

    val currentThemeModel: Flow<ThemeModel> = dynamicThemeRepository.currentThemeModel

    @Composable
    override fun ProvidesTheme(
        content: @Composable () -> Unit
    ) {
        val themeModel by dynamicThemeRepository.currentThemeModel.collectAsState(themeModelMapManager.getDefaultThemeModel())
        dynamicThemeProvider.ProvidesTheme(themeModel = themeModel, content = content)
    }

    @Composable
    override fun ProvidesTheme(
        themeModel: ThemeModel,
        content: @Composable () -> Unit
    ) {
        dynamicThemeProvider.ProvidesTheme(themeModel = themeModel, content = content)
    }

    override fun registerThemeModel(key: ThemeModelKey, themeModel: ThemeModel) {
        themeModelMapManager.putThemeModel(key = key, themeModel = themeModel)
    }

    override fun registerThemeModels(themeModelPairs: Map<ThemeModelKey, ThemeModel>) {
        themeModelPairs.forEach { key, themeModel ->
            registerThemeModel(key = key, themeModel = themeModel)
        }
    }

    override fun getThemeModels(): Map<ThemeModelKey, ThemeModel> {
        return themeModelMapManager.getSupportedThemeModels()
    }

    override fun getThemeModel(key: ThemeModelKey): ThemeModel {
        return themeModelMapManager.getThemeModel(key = key)
    }

    override fun removeThemeModel(key: ThemeModelKey) {
        themeModelMapManager.removeThemeModel(key = key)
    }

    override suspend fun getCurrentThemeModel(): ThemeModel {
        return currentThemeModel.first()
    }

    override suspend fun setCurrentThemeModel(key: ThemeModelKey) {
        dynamicThemeRepository.setCurrentThemeModel(key = key)
    }

    override fun getDefaultThemeModel(): ThemeModel {
        return themeModelMapManager.getDefaultThemeModel()
    }

    override fun setDefaultThemeModel(themeModel: ThemeModel) {
        themeModelMapManager.setDefaultThemeModel(themeModel = themeModel)
    }
}

interface DynamicThemeService {
    /**
     * Provides Theme with Currently Set ThemeModel
     */
    @Composable
    fun ProvidesTheme(
        content: @Composable () -> Unit
    )

    /**
     * Provides Theme with [themeModel] passed with parameter
     */
    @Composable
    fun ProvidesTheme(
        themeModel: ThemeModel,
        content: @Composable () -> Unit
    )

    /**
     * Register ThemeModel
     * [key]: ThemeModel can be access key
     * [themeModel]: Customizable ThemeModel
     */
    fun registerThemeModel(key: ThemeModelKey, themeModel: ThemeModel)

    /**
     * Register ThemeModel
     * [themeModelPairs]: Pairs of [ThemeModelKey] and [ThemeModel]
     */
    fun registerThemeModels(themeModelPairs: Map<ThemeModelKey, ThemeModel>)

    /**
     * Get registered ThemeModels
     */
    fun getThemeModels(): Map<ThemeModelKey, ThemeModel>

    /**
     * Get Register ThemeModel by [key]
     */
    fun getThemeModel(key: ThemeModelKey): ThemeModel

    /**
     * Remove registered ThemeModel by using [key]
     */
    fun removeThemeModel(key: ThemeModelKey)

    /**
     * Get currently set ThemeModel
     */
    suspend fun getCurrentThemeModel(): ThemeModel

    /**
     * Set current theme model which will be used on ui
     */
    suspend fun setCurrentThemeModel(key: ThemeModelKey)

    /**
     * Set Default [ThemeModel].
     * This is used when [ThemeModelKey.Default] were set as current [ThemeModelKey] or no matching ThemeModel were found.
     */
    fun setDefaultThemeModel(themeModel: ThemeModel)

    /**
     * Get Default [ThemeModel]
     */
    fun getDefaultThemeModel(): ThemeModel

    companion object {
        private var INSTANCE: DynamicThemeService? = null

        fun getInstance(context: Context): DynamicThemeService {
            require(context is Application) {
                throw IllegalArgumentException("Context must be application context")
            }

            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DynamicThemeServiceImpl(context).also { INSTANCE = it }
            }
        }
    }
}