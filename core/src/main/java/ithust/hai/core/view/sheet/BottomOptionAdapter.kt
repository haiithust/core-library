package ithust.hai.core.view.sheet

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ithust.hai.core.R
import ithust.hai.core.extension.drawableStart
import ithust.hai.core.extension.inflateHolder

/**
 * @author conghai on 8/26/20.
 */
class BottomOptionAdapter(
    private val selected: (item: BottomOption) -> Unit
) : RecyclerView.Adapter<BottomOptionHolder>() {
    private val list = mutableListOf<BottomOption>()

    fun setData(data: List<BottomOption>) {
        list.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomOptionHolder {
        return BottomOptionHolder(parent.inflateHolder(R.layout.core_item_option), selected)
    }

    override fun onBindViewHolder(holder: BottomOptionHolder, position: Int) {
        holder.invoke(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class BottomOptionHolder(view: View, selected: (item: BottomOption) -> Unit) : RecyclerView.ViewHolder(view) {
    init {
        itemView.setOnClickListener {
            selected.invoke(itemView.tag as BottomOption)
        }
    }

    operator fun invoke(item: BottomOption) {
        itemView.tag = item
        (itemView as TextView).apply {
            drawableStart(item.icon)
            text = item.title
        }
    }
}