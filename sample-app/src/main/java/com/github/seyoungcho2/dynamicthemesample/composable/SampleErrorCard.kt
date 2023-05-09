package com.github.seyoungcho2.dynamicthemesample.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SampleErrorCard(modifier: Modifier = Modifier, title: String, onClick: () -> Unit) {
    Card(
        modifier = modifier.padding(2.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.error,
        contentColor = MaterialTheme.colors.onError,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.body1)
        }
    }
}