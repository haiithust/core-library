package ithust.hai.core.extension

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ithust.hai.core.base.BaseFragment


/**
 * @author conghai on 2019-11-02.
 */
fun Fragment.addFragment(@IdRes containerId: Int, fragment: Fragment) {
    val transaction = parentFragmentManager.beginTransaction()
    parentFragmentManager.fragments.forEach {
        if (it.isHidden.not()) {
            transaction.hide(it)
        }
    }

    transaction
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .add(containerId, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commitAllowingStateLoss()
}

fun Fragment.addChildFragment(@IdRes containerId: Int, fragment: Fragment, tag: String = fragment.javaClass.simpleName) {
    val transaction = childFragmentManager.beginTransaction()
    (childFragmentManager.findFragmentByTag(tag))?.let {
        childFragmentManager.fragments.forEach { _it ->
            if (_it.tag != tag && _it.isHidden.not()) {
                transaction.hide(_it)
            }
        }
        transaction.show(it).commitAllowingStateLoss()
    } ?: run {
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .add(containerId, fragment, tag)
            .addToBackStack(tag)
            .commitAllowingStateLoss()
    }
}

fun Fragment.back() {
    if (isResumed) {
        requireActivity().onBackPressed()
    }
}

fun Fragment.showShortToast(msg: CharSequence) {
    Snackbar.make(view!!, msg, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.showShortToast(@StringRes msg: Int) {
    Snackbar.make(view!!, msg, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.showDialogFragment(fragment: Fragment) {
    childFragmentManager.beginTransaction()
        .add(fragment, fragment.javaClass.simpleName)
        .commitAllowingStateLoss()
}


fun Fragment.browse(url: String, newTask: Boolean = false) = activity?.browse(url, newTask)

fun Context.browse(url: String, newTask: Boolean = false): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        false
    }
}


fun Fragment.share(text: String, subject: String = "") = activity?.share(text, subject)

fun Activity.share(text: String, subject: String = "") {
    ShareCompat.IntentBuilder.from(this)
        .setType("text/plain")
        .setChooserTitle(text)
        .setText(subject)
        .startChooser()
}


fun Fragment.email(email: String, subject: String = "", text: String = "") = activity?.email(email, subject, text)

fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.isNotEmpty())
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.isNotEmpty())
        intent.putExtra(Intent.EXTRA_TEXT, text)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }
    return false

}

fun Fragment.makeCall(number: String) = activity?.makeCall(number)

fun Context.makeCall(number: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}


fun Fragment.sendSMS(number: String, text: String = "") = activity?.sendSMS(number, text)

fun Context.sendSMS(number: String, text: String = ""): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$number"))
        intent.putExtra("sms_body", text)
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}