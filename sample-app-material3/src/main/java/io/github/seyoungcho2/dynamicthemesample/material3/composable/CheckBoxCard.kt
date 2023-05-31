package io.github.seyoungcho2.dynamicthemesample.material3.composable

import android.widget.CheckBox
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.seyoungcho2.dynamicthemesample.material3.R
import kotlin.random.Random

@Composable
fun CheckBoxCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)) {
            Text(text = "Work Items", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(12.dp))
            CheckBoxItem(title = "Drink water in the morning")
            CheckBoxItem(title = "Buy food on the mart")
            CheckBoxItem(title = "Build dynamic theme module")
            CheckBoxItem(title = "Make one commit")
            CheckBoxItem(title = "Jogging for an hour in the morning")
        }
    }
}

@Composable
fun CheckBoxItem(title: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(modifier = Modifier.size(34.dp), checked = Random.nextBoolean(), onCheckedChange = {})
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier,
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}