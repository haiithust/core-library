package ithust.hai.core.promo

import android.content.Context
import ithust.hai.core.R

/**
 * @author conghai on 9/11/20.
 */
object AppList {
    fun getAppList(context: Context): List<PromoApp> = listOf(
        PromoApp(
            "media.tun.recoderprivate",
            R.drawable.core_ic_recorder_pro,
            context.getString(R.string.core_recorder_pro_name),
            context.getString(R.string.core_recorder_pro_desc)
        ),
        PromoApp(
            "ithust.hai.babycare",
            R.drawable.core_ic_baby_care,
            context.getString(R.string.core_baby_care_name),
            context.getString(R.string.core_baby_care_desc)
        ),
        PromoApp(
            "ithust.hai.screenrecorder",
            R.drawable.core_ic_screen_recorder,
            context.getString(R.string.core_screen_recorder),
            context.getString(R.string.core_screen_recorder_desc)
        ),
    ).filter { it.packageName != context.packageName }
}