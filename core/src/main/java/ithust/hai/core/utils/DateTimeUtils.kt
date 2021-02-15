package ithust.hai.core.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author conghai on 2019-09-28.
 */
object DateTimeUtils {
    private val DATE_FORMAT_FULL_YEAR = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    private val DATE_TIME_FORMAT_FULL_YEAR = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.ENGLISH)
    private val DATE_TIME_FORMAT_SHORT_YEAR = SimpleDateFormat("HH:mm dd/MM/yy", Locale.ENGLISH)
    private val DATE_TIME_GLOBAL = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH)

    fun getDate(time: Long): String = DATE_FORMAT_FULL_YEAR.format(time)

    fun getDateTime(time: Long): String = DATE_TIME_FORMAT_FULL_YEAR.format(time)

    fun getDateTimeShortYear(time: Long): String = DATE_TIME_FORMAT_SHORT_YEAR.format(time)

    fun getCurrentTime() = DATE_TIME_GLOBAL.format(System.currentTimeMillis())
}