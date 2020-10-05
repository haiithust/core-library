package ithust.hai.core.extension

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

/**
 * @author conghai on 2019-10-16.
 */
fun RecyclerView.initVertical(context: Context) {
    layoutManager = LinearLayoutManager(context)
    (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
}

fun RecyclerView.initHorizontal(context: Context) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
}