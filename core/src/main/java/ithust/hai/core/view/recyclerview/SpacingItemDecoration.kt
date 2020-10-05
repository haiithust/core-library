package ithust.hai.core.view.recyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ithust.hai.core.R

/**
 * @author conghai on 2019-12-18.
 */
class SpacingItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val spacing = context.resources.getDimensionPixelSize(R.dimen.margin_large)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        outRect.top = spacing
        outRect.left = spacing
        outRect.right = spacing
        if (position.inc() == parent.adapter!!.itemCount) {
            outRect.bottom = spacing
        }
    }
}