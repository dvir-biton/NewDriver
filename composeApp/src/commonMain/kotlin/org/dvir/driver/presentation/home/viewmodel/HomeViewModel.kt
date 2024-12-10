package org.dvir.driver.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.daysUntil
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import org.dvir.driver.core.Constants
import org.dvir.driver.data.DriverDateRepository
import kotlin.math.max

class HomeViewModel(
    private val driverDateRepository: DriverDateRepository
): ViewModel() {
    private var _state = mutableStateOf(HomeState())
    val state = _state

    var isDateFound by mutableStateOf(false)
        private set

    var isDateDialogOpen by mutableStateOf(false)
        private set

    var changeDateButtonText by mutableStateOf("הזזת תאריך קבלת רישיון")
        private set

    init {
        setupLicenseDate()
    }

    private fun setupLicenseDate() {
        val dateMillis = driverDateRepository.getDate()
        if (dateMillis == null) {
            changeDateButtonText = "עדכון תאריך קיבלת רישיון"
            return
        }

        val date: LocalDate = Instant.fromEpochMilliseconds(dateMillis)
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date

        isDateFound = true
        val endDayAccompaniedDate = date.plus(DatePeriod(months = Constants.DAY_ACCOMPANIED_MONTHS))
        val endNightAccompaniedDate = date.plus(DatePeriod(months = Constants.NIGHT_ACCOMPANIED_MONTHS))
        val today: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        _state.value = state.value.copy(
            licenseDate = date,
            endDayAccompaniedDate = endDayAccompaniedDate,
            endNightAccompaniedDate = endNightAccompaniedDate,
            endDayAccompaniedDaysLeft = max(today.daysUntil(endDayAccompaniedDate) - 1, 0),
            endNightAccompaniedDaysLeft = max(today.daysUntil(endNightAccompaniedDate) - 1, 0)
        )
    }

    fun onChangeDate(date: LocalDate) {
        driverDateRepository.putDate(date.atStartOfDayIn(TimeZone.UTC).toEpochMilliseconds())
        setupLicenseDate() // setup date accordingly
        onCloseDateDialog()
    }

    fun onOpenDateDialog() {
        isDateDialogOpen = true
    }

    fun onCloseDateDialog() {
        isDateDialogOpen = false
    }
}