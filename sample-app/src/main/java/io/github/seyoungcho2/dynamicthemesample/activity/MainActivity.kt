package io.github.seyoungcho2.dynamicthemesample.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import io.github.seyoungcho2.dynamicthemesample.R
import io.github.seyoungcho2.dynamicthemesample.composable.SampleErrorCard
import io.github.seyoungcho2.dynamicthemesample.composable.SampleItemCard
import io.github.seyoungcho2.dynamicthemesample.composable.SampleNotificationCard
import io.github.seyoungcho2.dynamicthemesample.composable.ThemeCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeThemeChange()

        setContent {
            val supportedThemes by mainViewModel.supportedThemes.collectAsState()

            var isErrorVisible by remember { mutableStateOf(false) }
            var isNotificationVisible by remember { mutableStateOf(false) }

            mainViewModel.ProvidesTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    val verticalScrollState = rememberScrollState()
                    Column(
                        Modifier
                            .padding(12.dp)
                            .verticalScroll(verticalScrollState)
                    ) {
                        Text(
                            text = "Themes",
                            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colors.onBackground
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        val horizontalScrollState = rememberScrollState()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(horizontalScrollState),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (supportedTheme in supportedThemes) {
                                ThemeCard(
                                    themeTitle = mainViewModel.getName(supportedTheme.key),
                                    themeBackground = supportedTheme.value.colorPalette.lightModeColors.background,
                                    themeForeground = supportedTheme.value.colorPalette.lightModeColors.onBackground,
                                    onClick = {
                                        mainViewModel.setCurrentThemeModel(supportedTheme.key)
                                    }
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Items",
                            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colors.onBackground
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        SampleItemCard(
                            imageRes = R.drawable.example1,
                            title = "Surface Color",
                            content = "Click to show secondary color card"
                        ) {
                            isNotificationVisible = true
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        AnimatedVisibility(
                            modifier = Modifier,
                            visible = isNotificationVisible
                        ) {
                            SampleNotificationCard(title = "Secondary Color") {
                                // Do nothing
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        SampleItemCard(
                            imageRes = R.drawable.example2,
                            title = "Surface Color",
                            content = "Click to make error"
                        ) {
                            isErrorVisible = true
                        }


                        Spacer(modifier = Modifier.height(20.dp))
                    }


                    Button(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(12.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors()
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "Primary Color",
                            style = MaterialTheme.typography.h6
                        )
                    }

                    AnimatedVisibility(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp),
                        visible = isErrorVisible
                    ) {
                        SampleErrorCard(title = "Error Color") {
                            // Do nothing
                        }
                    }

                    LaunchedEffect(key1 = isErrorVisible) {
                        if (isErrorVisible) {
                            delay(1000L)
                            isErrorVisible = false
                        }
                    }

                    LaunchedEffect(key1 = isNotificationVisible) {
                        if (isNotificationVisible) {
                            delay(1000L)
                            isNotificationVisible = false
                        }
                    }
                }
            }
        }
    }

    private fun observeThemeChange() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.currentThemeModel.collectLatest {
                    val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                    val isDarkMode = currentNightMode == Configuration.UI_MODE_NIGHT_YES

                    window.statusBarColor = if (isDarkMode) {
                        it.colorPalette.darkModeColors.background.toArgb()
                    } else {
                        it.colorPalette.lightModeColors.background.toArgb()
                    }
                }
            }
        }
    }
}