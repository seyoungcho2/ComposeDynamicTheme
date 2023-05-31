package io.github.seyoungcho2.dynamicthemesample.material3.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.seyoungcho2.dynamicthemesample.material3.R

@Composable
fun NotificationCard(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column() {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.baseline_lightbulb_24),
                    contentDescription = "light bulb"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier,
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}