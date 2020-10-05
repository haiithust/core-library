package ithust.hai.core.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * @author conghai on 3/21/20.
 */
object PermissionUtils {
    fun checkPermission(context: Context, permissions: Array<String>): Boolean {
        permissions.forEach {
            if (ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED) return false
        }
        return true
    }
}