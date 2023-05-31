package io.github.seyoungcho2.dynamicthemesample.material3.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeCard(themeTitle: String, themeBackground: Color, themeForeground: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(2.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = themeBackground, contentColor = themeForeground),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .size(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = themeTitle, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }
    }
}