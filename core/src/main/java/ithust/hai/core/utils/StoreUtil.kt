package ithust.hai.core.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @author conghai on 8/7/20.
 */
object StoreUtil {
    fun navigate(context: Context, packageName: String) {
        try {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                }
            }
        } catch (ignore: Exception) {
        }
    }
}