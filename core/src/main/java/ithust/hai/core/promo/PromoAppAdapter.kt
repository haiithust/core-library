package ithust.hai.core.promo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ithust.hai.core.R
import ithust.hai.core.databinding.CoreItemAppBinding
import ithust.hai.core.extension.inflateHolder

/**
 * @author conghai on 9/11/20.
 */
class PromoAppAdapter(private val onClick: (pos: Int) -> Unit) :
    RecyclerView.Adapter<PromoAppHolder>() {
    private val list = mutableListOf<PromoApp>()

    fun setData(data: List<PromoApp>) {
        list.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoAppHolder {
        return PromoAppHolder(
            CoreItemAppBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: PromoAppHolder, position: Int) = holder(list[position])

    override fun getItemCount(): Int = list.size
}

class PromoAppHolder(private val binding: CoreItemAppBinding, onClick: (pos: Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    operator fun invoke(app: PromoApp) {
        binding.ivApp.setImageResource(app.resId)
        binding.tvAppTitle.text = app.name
        binding.tvAppDesc.text = app.desc
    }
}