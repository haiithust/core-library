package ithust.hai.core.playcore

import androidx.fragment.app.FragmentActivity
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import javax.inject.Inject

/**
 * @author conghai on 9/30/20.
 */
class MyAppReviewManager @Inject constructor(private val activity: FragmentActivity) {
    private val manager: ReviewManager = ReviewManagerFactory.create(activity.applicationContext)
    private var reviewInfo: ReviewInfo? = null

    fun loadReviewInfo() {
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener {
            if (it.isSuccessful) {
                reviewInfo = request.result
            }
        }
    }

    fun showReview(doneCallback: () -> Unit) {
        reviewInfo?.let {
            val flow = manager.launchReviewFlow(activity, it)
            flow.addOnCompleteListener {
                doneCallback()
            }
        } ?: run {
            doneCallback.invoke()
        }
    }
}