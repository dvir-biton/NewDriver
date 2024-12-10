package org.dvir.driver.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dvir.driver.presentation.home.components.indicators.AccompaniedIndicators
import org.dvir.driver.presentation.home.components.permits.PermitsAndRestrictions
import org.dvir.driver.presentation.home.viewmodel.HomeViewModel
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
                    .padding(32.dp)
            ) {
                AccompaniedIndicators(
                    viewModel.state.value.endDayAccompaniedDaysLeft,
                    viewModel.state.value.endNightAccompaniedDaysLeft
                )

                Spacer(modifier = Modifier.height(64.dp))

                PermitsAndRestrictions(
                    canDriveAtDay = viewModel.state.value.endDayAccompaniedDaysLeft <= 0,
                    canDriveAtNight = viewModel.state.value.endNightAccompaniedDaysLeft <= 0
                )
            }
        } else {

        }
    }
}

