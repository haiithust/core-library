package ithust.hai.core.extension

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * @author conghai on 2019-08-29.
 */
fun RecyclerView.ViewHolder.textOf(@StringRes stringRes: Int): String = itemView.context.getString(stringRes)

fun RecyclerView.ViewHolder.textOf(@StringRes stringRes: Int, vararg formatArgs: Any): String = itemView.context.getString(stringRes, *formatArgs)

fun RecyclerView.ViewHolder.colorOf(@ColorRes colorRes: Int): Int = ContextCompat.getColor(itemView.context, colorRes)

fun RecyclerView.ViewHolder.sizeOf(@DimenRes dimenRes: Int): Int = itemView.context.resources.getDimensionPixelSize(dimenRes)

fun RecyclerView.ViewHolder.sizeOfFloat(@DimenRes dimenRes: Int): Float = itemView.context.resources.getDimension(dimenRes)