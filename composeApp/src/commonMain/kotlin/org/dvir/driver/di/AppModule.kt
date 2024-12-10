package org.dvir.driver.di

import org.dvir.driver.data.DriverDateRepository
import org.dvir.driver.data.SettingsDriverDateRepository
import org.dvir.driver.presentation.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<DriverDateRepository> {
        SettingsDriverDateRepository()
    }

     viewModel<HomeViewModel> {
         HomeViewModel(get<DriverDateRepository>())
     }
}