package ithust.hai.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ithust.hai.core.R

/**
 * @author conghai on 2019-06-05.
 */
abstract class BaseBindingFullDialogFragment<B : ViewBinding> : DialogFragment() {
    private var _binding: B? = null
    protected val binding: B
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogFragment)
        loadParameters()
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = initViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        initUI()
        observer()
        registerEvents()
        loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected open fun inject() {}
    protected open fun loadParameters() {}
    protected open fun initUI() {}
    protected open fun registerEvents() {}
    protected open fun observer() {}
    protected open fun loadData() {}

    abstract fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): B
}