package org.dvir.driver.presentation.home

import kotlinx.datetime.LocalDate

data class HomeState(
    val licenseDate: LocalDate? = null,
    val endDayAccompaniedDate: LocalDate? = null,
    val endNightAccompaniedDate: LocalDate? = null,
    val endDayAccompaniedDaysLeft: Int = 0,
    val endNightAccompaniedDaysLeft: Int = 0,
)
