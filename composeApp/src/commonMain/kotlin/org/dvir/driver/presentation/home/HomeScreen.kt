package org.dvir.driver.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dvir.driver.core.Constants
import org.dvir.driver.presentation.home.components.CircularProgressIndicator
import org.dvir.driver.presentation.theme.colors.BackgroundColor
import org.dvir.driver.presentation.theme.colors.SurfaceColor
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    Scaffold(
        backgroundColor = BackgroundColor,
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SurfaceColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "נהג חדש",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextColor,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
        }
    ) {
        if (viewModel.isDateFound) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    val percentageDay = (Constants.DAY_ACCOMPANIED_DAYS - viewModel.state.value.endDayAccompaniedDaysLeft) / Constants.DAY_ACCOMPANIED_DAYS.toFloat()
                    CircularProgressIndicator(
                        percentage = percentageDay,
                        color = Color(0xFFFDFD96),
                        backgroundColor = SurfaceColor,
                        strokeWidth = 16f,
                        daysLeft = viewModel.state.value.endDayAccompaniedDaysLeft,
                        title = {
                            Text(
                                text = "מלווה יום",
                                color = TextColor
                            )
                        }
                    )

                    val percentageNight = (Constants.NIGHT_ACCOMPANIED_DAYS - viewModel.state.value.endNightAccompaniedDaysLeft) / Constants.NIGHT_ACCOMPANIED_DAYS.toFloat()
                    CircularProgressIndicator(
                        percentage = percentageNight,
                        color = Color(0xFFADD8E6),
                        backgroundColor = SurfaceColor,
                        strokeWidth = 16f,
                        daysLeft = viewModel.state.value.endNightAccompaniedDaysLeft,
                        title = {
                            Text(
                                text = "מלווה לילה",
                                color = TextColor
                            )
                        }
                    )
                }
            }
        } else {

        }
    }
}

