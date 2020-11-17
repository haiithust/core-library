package ithust.hai.core.extension

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author conghai on 2020-02-11.
 */
fun AppCompatActivity.addFragment(@IdRes containerId: Int, fragment: Fragment) {
    val tag = fragment.javaClass.simpleName
    val transaction = supportFragmentManager.beginTransaction()
    supportFragmentManager.fragments.forEach {
        if (it.tag != tag && it.isHidden.not()) {
            transaction.hide(it)
        }
    }
    supportFragmentManager.findFragmentByTag(tag)?.let {
        transaction.show(it)
    } ?: run {
        transaction
            .add(containerId, fragment, tag)
    }
    transaction.commitAllowingStateLoss()
}

inline fun <reified T : AppCompatActivity> intentTo(context: Context): Intent {
    return Intent(context, T::class.java)
}