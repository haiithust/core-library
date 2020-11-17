package ithust.hai.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author conghai on 2019-06-05.
 */
abstract class BaseFragment(@LayoutRes val layoutResourceId: Int = 0) : Fragment(layoutResourceId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadParameters()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        initUI()
        observer()
        registerEvents()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
    }

    protected open fun inject() {}
    protected open fun loadParameters() {}
    protected open fun initUI() {}
    protected open fun registerEvents() {}
    protected open fun observer() {}
    protected open fun loadData() {}
}