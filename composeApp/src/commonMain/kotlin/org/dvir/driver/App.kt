package org.dvir.driver

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.dvir.driver.presentation.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen(koinInject())
    }
}