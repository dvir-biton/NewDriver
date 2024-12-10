package org.dvir.driver.presentation.home.components.permits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dvir.driver.presentation.theme.colors.DayColor
import org.dvir.driver.presentation.theme.colors.NightColor
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun PermitsAndRestrictions(
    canDriveAtDay: Boolean,
    canDriveAtNight: Boolean
) {
    Column {
        Text(
            text = "היתרים והגבלות",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextColor,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        PermitField(
            checked = canDriveAtDay,
            mainColor = DayColor,
            text = "רשאי/ת לנסוע ללא ליווי ביום"
        )

        Spacer(modifier = Modifier.height(8.dp))

        PermitField(
            checked = canDriveAtNight,
            mainColor = NightColor,
            text = "רשאי/ת לנסוע ללא ליווי בלילה"
        )
    }
}