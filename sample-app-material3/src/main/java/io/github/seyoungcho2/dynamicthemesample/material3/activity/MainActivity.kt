package io.github.seyoungcho2.dynamicthemesample.material3.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import io.github.seyoungcho2.dynamictheme.material3.DynamicThemeService
import io.github.seyoungcho2.dynamicthemesample.material3.R
import io.github.seyoungcho2.dynamicthemesample.material3.composable.CheckBoxCard
import io.github.seyoungcho2.dynamicthemesample.material3.composable.NotificationCard
import io.github.seyoungcho2.dynamicthemesample.material3.composable.ThemeCard
import io.github.seyoungcho2.dynamicthemesample.material3.theme.ThemeNameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dynamicThemeService = DynamicThemeService.get()
        setContent {
            val registeredThemes = remember { dynamicThemeService.getRegisteredThemeModels() }
            DynamicThemeService.get().ProvidesTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val verticalScrollState = rememberScrollState()
                    Column(
                        Modifier
                            .padding(12.dp)
                            .verticalScroll(verticalScrollState)
                    ) {
                        Text(
                            text = "Themes",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        val horizontalScrollState = rememberScrollState()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(horizontalScrollState),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (supportedTheme in registeredThemes) {
                                ThemeCard(
                                    themeTitle = ThemeNameRepository.getThemeName(supportedTheme.key),
                                    themeBackground = supportedTheme.value.colorPalette.lightModeColors.background,
                                    themeForeground = supportedTheme.value.colorPalette.lightModeColors.onBackground,
                                    onClick = {
                                        lifecycleScope.launch(Dispatchers.IO) {
                                            dynamicThemeService.setCurrentThemeModel(supportedTheme.key)
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Today",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        NotificationCard(
                            modifier = Modifier.fillMaxWidth(),
                            text = "How about a cup of coffee in the morning?"
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        CheckBoxCard(modifier = Modifier.fillMaxWidth())
                    }

                    FloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp),
                        onClick = { },
                        containerColor = MaterialTheme.colorScheme.primary
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "Add Button",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }
}