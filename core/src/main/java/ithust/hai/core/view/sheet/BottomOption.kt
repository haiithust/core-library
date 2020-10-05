package ithust.hai.core.view.sheet

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * @author conghai on 8/26/20.
 */
@Parcelize
data class BottomOption(val groupId: Int, @DrawableRes val icon: Int, val title: String, val value: Int) : Parcelable