package org.dvir.driver.data

interface DriverDateRepository {
    fun putDate(dateMillis: Long)
    fun getDate(): Long?
    fun clearDate()
}