package com.simplit.dynamicthemesample.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ThemeCard(themeTitle: String, themeBackground: Color, themeForeground: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(2.dp),
        elevation = 2.dp,
        backgroundColor = themeBackground,
        contentColor = themeForeground,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .size(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = themeTitle, style = MaterialTheme.typography.body2)
        }
    }
}