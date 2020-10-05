package ithust.hai.core.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author conghai on 2019-09-28.
 */
object DateTimeUtils {
    private val DATE_FORMAT_FULL_YEAR = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    private val DATE_TIME_FORMAT_FULL_YEAR = SimpleDateFormat("hh:mm dd/MM/yyyy", Locale.ENGLISH)

    fun getDate(time: Long): String = DATE_FORMAT_FULL_YEAR.format(time)

    fun getDateTime(time: Long): String = DATE_TIME_FORMAT_FULL_YEAR.format(time)
}