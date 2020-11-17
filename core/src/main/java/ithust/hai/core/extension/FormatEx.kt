package ithust.hai.core.extension

/**
 * @author conghai on 2019-12-13.
 */
fun String.convertToFloat(): Float {
    return try {
        toFloat()
    } catch (e: Exception) {
        0f
    }
}