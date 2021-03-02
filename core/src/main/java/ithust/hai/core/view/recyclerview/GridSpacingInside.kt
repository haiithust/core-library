package ithust.hai.core.view.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * @author conghai
 */
class GridSpacingInside(private val spanCount: Int, private val spacing: Int) : ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        when (position % spanCount) {
            0 -> {
                outRect.right = spacing / 2
                outRect.left = spacing
            }
            spanCount - 1 -> {
                outRect.left = spacing / 2
                outRect.right = spacing
            }
            else -> {
                outRect.left = spacing / 2
                outRect.right = spacing / 2
            }
        }
        outRect.top = spacing
        if (position > parent.adapter!!.itemCount - spanCount) {
            outRect.bottom = spacing
        }
    }
}