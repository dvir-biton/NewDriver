package org.dvir.driver.presentation.home.components.dates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kotlinx.datetime.LocalDate
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun DateText(
    text: String,
    date: LocalDate
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = date.toString(),
            fontWeight = FontWeight.Bold,
            color = TextColor,
        )
        Text(
            text = text,
            color = TextColor,
        )
    }
}