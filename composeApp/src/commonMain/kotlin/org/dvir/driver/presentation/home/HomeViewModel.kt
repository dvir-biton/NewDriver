package org.dvir.driver.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import org.dvir.driver.data.DriverDateRepository

class HomeViewModel(
    private val driverDateRepository: DriverDateRepository
): ViewModel() {
    private var _state = mutableStateOf(HomeState())
    val state = _state

    var isDateFound by mutableStateOf(false)
        private set

    var isDateDialogOpen by mutableStateOf(false)
        private set

    init {
        driverDateRepository.putDate(1733461868000)
        setupLicenseDate()
    }

    private fun setupLicenseDate() {
        val dateMillis = driverDateRepository.getDate() ?: return
        val date: LocalDate = Instant.fromEpochMilliseconds(dateMillis)
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date

        isDateFound = true
        val endDayAccompaniedDate = date.plus(DatePeriod(months = 3))
        val endNightAccompaniedDate = date.plus(DatePeriod(months = 6))
        val today: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        _state.value = state.value.copy(
            licenseDate = date,
            endDayAccompaniedDate = endDayAccompaniedDate,
            endNightAccompaniedDate = endNightAccompaniedDate,
            endDayAccompaniedDaysLeft = today.daysUntil(endDayAccompaniedDate) - 1,
            endNightAccompaniedDaysLeft = today.daysUntil(endNightAccompaniedDate) - 1
        )
    }

    fun onOpenDateDialog() {
        isDateDialogOpen = true
    }

    fun onCloseDateDialog() {
        isDateDialogOpen = false
    }
}