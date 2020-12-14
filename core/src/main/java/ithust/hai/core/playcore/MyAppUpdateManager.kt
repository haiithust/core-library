package ithust.hai.core.playcore

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import timber.log.Timber
import javax.inject.Inject

/**
 * @author conghai on 10/6/20.
 */
class MyAppUpdateManager @Inject constructor(
    private val activity: FragmentActivity
) {
    var onShowCompleteUpdate: (() -> Unit)? = null
    private val appUpdateManager: AppUpdateManager = AppUpdateManagerFactory.create(activity)
    private var shouldRequest: Boolean = true

    private val listener = InstallStateUpdatedListener { state ->
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            onShowCompleteUpdate?.invoke()
        }
    }

    fun checkForUpdate(requestCode: Int) {
        if (shouldRequest) {
            appUpdateManager.appUpdateInfo.addOnSuccessListener { appUpdateInfo ->
                Timber.d("updateAvailability: ${appUpdateInfo.updateAvailability()}, status: ${appUpdateInfo.installStatus()}")
                if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADING) {
                    registerEvent()
                } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                    onShowCompleteUpdate?.invoke()
                } else if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)
                ) {
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.FLEXIBLE,
                        activity,
                        requestCode
                    )
                } else {
                    shouldRequest = false
                }
            }
        }
    }

    fun disableCheckForUpdate() {
        shouldRequest = false
    }

    fun registerEvent() {
        appUpdateManager.registerListener(listener)
    }

    fun unregisterEvent() {
        appUpdateManager.unregisterListener(listener)
    }

    // activity.getString(R.string.app_has_been_downloaded)
    fun showCompleteUpdate(view: View, anchorView: View, message: String, action: String) {
        Snackbar.make(
            view,
            message,
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAnchorView(anchorView)
            setAction(action) {
                appUpdateManager.completeUpdate()
            }
            show()
        }
    }
}