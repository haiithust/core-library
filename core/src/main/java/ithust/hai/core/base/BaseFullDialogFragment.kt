package ithust.hai.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import ithust.hai.core.R

/**
 * @author conghai on 2019-06-05.
 */
abstract class BaseFullDialogFragment(@LayoutRes val layoutResourceId: Int) : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogFragment)
        loadParameters()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResourceId, container, false)
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