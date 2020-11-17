package ithust.hai.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * @author conghai on 2019-06-05.
 */
abstract class BaseBindingFragment<B : ViewBinding> : BaseFragment() {
    private var _binding: B? = null
    protected val binding: B
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = initViewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): B
}