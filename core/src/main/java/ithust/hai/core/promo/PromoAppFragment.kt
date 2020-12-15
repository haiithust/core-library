package ithust.hai.core.promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import ithust.hai.core.R
import ithust.hai.core.base.BaseBindingFragment
import ithust.hai.core.databinding.CoreFragmentPromoAppBinding
import ithust.hai.core.extension.back
import ithust.hai.core.extension.initVertical
import ithust.hai.core.utils.ExtraKey
import ithust.hai.core.utils.StoreUtil

/**
 * @author conghai on 9/10/20.
 */
class PromoAppFragment : BaseBindingFragment<CoreFragmentPromoAppBinding>() {
    private val appList: List<PromoApp> by lazy { AppList.getAppList(requireContext()) }

    private val onClick: (pos: Int) -> Unit = {
        val promoApp = appList[it]
        StoreUtil.navigate(requireContext(), promoApp.packageName)
    }

    private val adapter = PromoAppAdapter(onClick)

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): CoreFragmentPromoAppBinding {
        return CoreFragmentPromoAppBinding.inflate(inflater, container, false)
    }

    override fun initUI() {
        if (requireArguments().getBoolean(ExtraKey.A)) {
            binding.toolbar.setNavigationIcon(R.drawable.core_ic_back)
            binding.toolbar.setNavigationOnClickListener {
                back()
            }
        }
        binding.rvAppList.apply {
            initVertical(context)
            adapter = this@PromoAppFragment.adapter
        }
        adapter.setData(appList)
    }

    companion object {
        fun newInstance(isShowBackIcon: Boolean) = PromoAppFragment().apply {
            arguments = bundleOf(ExtraKey.A to isShowBackIcon)
        }
    }
}