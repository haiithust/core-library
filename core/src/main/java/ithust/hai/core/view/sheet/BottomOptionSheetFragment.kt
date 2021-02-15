package ithust.hai.core.view.sheet

import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ithust.hai.core.R
import ithust.hai.core.databinding.CoreFragmentBottomOptionSheetBinding
import ithust.hai.core.extension.initVertical
import ithust.hai.core.utils.ExtraKey
import java.util.*

/**
 * @author conghai on 8/26/20.
 */
class BottomOptionSheetFragment : BottomSheetDialogFragment() {
    private var _binding: CoreFragmentBottomOptionSheetBinding? = null
    private val binding: CoreFragmentBottomOptionSheetBinding
        get() = _binding!!

    private val adapter = BottomOptionAdapter {
        listener.onOptionSelected(it)
        dismissAllowingStateLoss()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return CoreFragmentBottomOptionSheetBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            initVertical(context)
            adapter = this@BottomOptionSheetFragment.adapter
        }
        val title = requireArguments().getString(ExtraKey.B)
        binding.tvTitle.apply {
            isVisible = title.isNullOrBlank().not()
            text = title
        }
        binding.divider.isVisible = binding.tvTitle.isVisible

        val options = requireArguments().getParcelableArrayList<BottomOption>(ExtraKey.A).orEmpty()
        if (options.isNotEmpty()) {
            adapter.setData(options)
        } else {
            dismissAllowingStateLoss()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        listener.onCancel()
    }

    private val listener: BottomOptionSelectListener
        get() {
            if (parentFragment is BottomOptionSelectListener) return parentFragment as BottomOptionSelectListener
            if (activity is BottomOptionSelectListener) return activity as BottomOptionSelectListener
            throw ClassCastException("Must implements BottomOptionSelectListener")
        }

    companion object {
        fun getInstance(title: String = "", list: MutableList<BottomOption>) = BottomOptionSheetFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(
                        ExtraKey.A,
                        list as ArrayList<out Parcelable>
                )
                putString(ExtraKey.B, title)
            }
        }
    }
}

interface BottomOptionSelectListener {
    fun onOptionSelected(option: BottomOption)
    fun onCancel() {}
}