package ithust.hai.core.extension

import kotlinx.coroutines.Job

/**
 * @author conghai on 10/7/20.
 */
val Job?.isNotActive: Boolean
    get() = this?.isActive != true