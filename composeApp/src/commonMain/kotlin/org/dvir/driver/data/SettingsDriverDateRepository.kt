package org.dvir.driver.data

import com.russhwolf.settings.Settings

class SettingsDriverDateRepository: DriverDateRepository {
    private val settings: Settings = Settings()

    override fun putDate(dateMillis: Long) {
        settings.putLong("date", dateMillis)
    }

    override fun getDate(): Long? {
        return settings.getLongOrNull("date")
    }

    override fun clearDate() {
        settings.remove("date")
    }
}