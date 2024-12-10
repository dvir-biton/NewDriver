package org.dvir.driver

import androidx.compose.ui.window.ComposeUIViewController
import org.dvir.driver.di.appModule
import org.koin.core.context.startKoin

var wasKoinInitialized = false

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}

fun initKoin() {
    if (!wasKoinInitialized) {
        startKoin {
            modules(appModule)
        }
        wasKoinInitialized = true
    }
}