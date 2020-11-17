package ithust.hai.core.base

import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

/**
 * @author conghai on 2019-06-05.
 */
abstract class BaseBindingActivity<B : ViewBinding> : BaseActivity {
    protected lateinit var binding: B

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    abstract fun initViewBinding(): B

    @CallSuper
    override fun initUI() {
        binding = initViewBinding()
        setContentView(binding.root)
    }
}