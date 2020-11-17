package ithust.hai.core.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.DecimalFormat

/**
 * @author conghai on 2019-08-15.
 */
object UIUtils {
    private val formatter = DecimalFormat("#.#")

    fun hideKeyboard(v: View?) {
        if (v == null || v.context == null || v.windowToken == null) return
        val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }

    fun format(value: Float): String = formatter.format(value)
}