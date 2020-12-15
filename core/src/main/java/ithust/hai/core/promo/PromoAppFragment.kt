package ithust.hai.core.promo

import android.view.LayoutInflater
import android.view.ViewGroup
import ithust.hai.core.base.BaseBindingFragment
import ithust.hai.core.databinding.CoreFragmentPromoAppBinding
import ithust.hai.core.extension.initVertical
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
        binding.rvAppList.apply {
            initVertical(context)
            adapter = this@PromoAppFragment.adapter
        }
        adapter.setData(appList)
    }
}