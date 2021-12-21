package cn.itpiggy.animation.helpers

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.BounceInterpolator
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

class FlyingBounceHelper @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintHelper(context, attrs, defStyleAttr) {
    var mContainer: ConstraintLayout? = null
    override fun updatePreLayout(container: ConstraintLayout?) {
        if (mContainer != container) {
            val views = getViews(container)
            for (i in 0..mCount-1) {
                val view = views[i]
                ObjectAnimator.ofFloat(view, "translationX", -2000f, 0f).apply {
                    duration = 1000
                    interpolator = BounceInterpolator()
                    start()
                }
            }
        }
        mContainer = container
    }
}