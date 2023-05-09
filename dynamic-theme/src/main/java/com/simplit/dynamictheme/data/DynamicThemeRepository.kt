package com.simplit.dynamictheme.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.simplit.dynamictheme.model.ThemeModel
import com.simplit.dynamictheme.model.ThemeModelKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DynamicThemeRepositoryImpl internal constructor(
    private val context: Context,
    private val themeModelMapManager: ThemeModelMapManager
) : DynamicThemeRepository {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_repository")
    private fun getData() = context.dataStore.data

    override suspend fun setCurrentThemeModel(key: ThemeModelKey) {
        if(!themeModelMapManager.containsKey(key)) throw IllegalArgumentException("ThemeModelKey ${key} not registered ")
        context.dataStore.edit { preference ->
            preference[CURRENT_THEME_MODEL_STRING] = key.key
        }
    }

    override val currentThemeModel: Flow<ThemeModel>
        get() = getData().map { preference ->
            val themeModelKeyString = preference[CURRENT_THEME_MODEL_STRING]

            val themeModelKey = ThemeModelKey.of(themeModelKeyString)

            themeModelMapManager.getThemeModel(themeModelKey)
        }

    companion object {
        private val CURRENT_THEME_MODEL_STRING = stringPreferencesKey("CURRENT_THEME_MODEL_STRING")
    }
}

interface DynamicThemeRepository {
    /**
     * Register Current Theme Model
     */
    suspend fun setCurrentThemeModel(key: ThemeModelKey)

    /**
     * Get Current Registered Theme Model
     */
    val currentThemeModel: Flow<ThemeModel>
}