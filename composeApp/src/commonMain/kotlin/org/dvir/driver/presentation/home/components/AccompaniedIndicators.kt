package org.dvir.driver.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.dvir.driver.core.Constants
import org.dvir.driver.presentation.theme.colors.SurfaceColor
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun AccompaniedIndicators(
    endDayAccompaniedDaysLeft: Int,
    endNightAccompaniedDaysLeft: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val percentageDay = (Constants.DAY_ACCOMPANIED_DAYS - endDayAccompaniedDaysLeft) / Constants.DAY_ACCOMPANIED_DAYS.toFloat()
        CircularProgressIndicator(
            percentage = percentageDay,
            color = Color(0xFFFDFD96),
            backgroundColor = SurfaceColor,
            strokeWidth = 16f,
            daysLeft = endDayAccompaniedDaysLeft,
            title = {
                Text(
                    text = "מלווה יום",
                    color = TextColor
                )
            }
        )

        val percentageNight = (Constants.NIGHT_ACCOMPANIED_DAYS - endNightAccompaniedDaysLeft) / Constants.NIGHT_ACCOMPANIED_DAYS.toFloat()
        CircularProgressIndicator(
            percentage = percentageNight,
            color = Color(0xFFADD8E6),
            backgroundColor = SurfaceColor,
            strokeWidth = 16f,
            daysLeft = endNightAccompaniedDaysLeft,
            title = {
                Text(
                    text = "מלווה לילה",
                    color = TextColor
                )
            }
        )
    }
}