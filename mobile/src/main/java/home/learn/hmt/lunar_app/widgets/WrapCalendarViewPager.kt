package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class WrapCalendarViewPager
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {
    private var mSwipeEnabled = true
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
       /* var height = 0
        for (i in 0 until childCount) {
            var child = getChildAt(i)
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            var h = child.measuredHeight

            if (h > height) {
                height = h
            }
        }
        var heightTemp = heightMeasureSpec
        if (height != 0) {
            heightTemp = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        }*/
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun setSwipeEnabled(swipeEnable: Boolean? = false) {
        swipeEnable?.let {
            this.mSwipeEnabled = it
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return mSwipeEnabled && super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return mSwipeEnabled && super.onTouchEvent(ev)
    }
}