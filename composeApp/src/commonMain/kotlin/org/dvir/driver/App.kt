package org.dvir.driver

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.dvir.driver.di.appModule
import org.dvir.driver.presentation.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

@Composable
@Preview
fun App() {
    startKoin {
        modules(listOf(appModule))
    }
    MaterialTheme {
        HomeScreen(koinInject())
    }
}