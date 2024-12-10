package org.dvir.driver.presentation.home.components.dates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.LocalDate
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun LicenseDates(
    licenseDate: LocalDate,
    endDayAccompaniedDate: LocalDate,
    endNightAccompaniedDate: LocalDate,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "תאריכים",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        DateText(
            text = " :תאריך הנפקת הרישיון",
            date = licenseDate
        )

        Spacer(modifier = Modifier.height(8.dp))

        DateText(
            text = " :תאריך סיום מלווה יום",
            date = endDayAccompaniedDate
        )

        Spacer(modifier = Modifier.height(8.dp))

        DateText(
            text = " :תאריך סיום מלווה לילה",
            date = endNightAccompaniedDate
        )
    }
}