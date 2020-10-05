package ithust.hai.core.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes

/**
 * @author conghai on 3/2/20.
 */
fun ViewGroup.inflateHolder(@LayoutRes layoutId: Int): View = LayoutInflater.from(context).inflate(layoutId, this, false)

fun TextView.drawableEnd(@DrawableRes resId: Int) = setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, resId, 0)

fun TextView.drawableTop(@DrawableRes resId: Int) = setCompoundDrawablesRelativeWithIntrinsicBounds(0, resId, 0, 0)

fun TextView.drawableStart(@DrawableRes resId: Int) = setCompoundDrawablesRelativeWithIntrinsicBounds(resId, 0, 0, 0)