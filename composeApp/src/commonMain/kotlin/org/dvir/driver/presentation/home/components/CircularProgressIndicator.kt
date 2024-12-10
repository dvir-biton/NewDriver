package org.dvir.driver.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dvir.driver.presentation.theme.colors.TextColor

@Composable
fun CircularProgressIndicator(
    percentage: Float,
    strokeWidth: Float = 8f,
    modifier: Modifier = Modifier.size(100.dp),
    color: Color = Color.Blue,
    backgroundColor: Color = Color.Gray,
    daysLeft: Int,
    title: @Composable () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = modifier) {
                val diameter = size.minDimension
                val radius = diameter / 2
                val center = Offset(size.width / 2, size.height / 2)

                // Draw the background circle
                drawCircle(
                    color = backgroundColor,
                    radius = radius,
                    center = center,
                    style = Stroke(width = strokeWidth)
                )

                // Draw the progress arc
                drawArc(
                    color = color,
                    startAngle = -90f, // Start from the top
                    sweepAngle = 360 * percentage,
                    useCenter = false,
                    style = Stroke(width = strokeWidth),
                    size = Size(diameter, diameter),
                    topLeft = Offset((size.width - diameter) / 2, (size.height - diameter) / 2)
                )
            }

            Text(
                text = daysLeft.toString(),
                color = TextColor,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        title()
    }
}