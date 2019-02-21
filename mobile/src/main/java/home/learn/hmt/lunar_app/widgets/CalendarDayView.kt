package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import home.learn.hmt.lunar_app.R
import kotlinx.android.synthetic.main.view_calendar_day.view.*

class CalendarDayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        View.inflate(getContext(), R.layout.view_calendar_day, this)
        tv_calendar_day_text.text = "ABC"
    }

    fun setThisMothTextColor() {
        tv_calendar_day_text.setTextColor(ContextCompat.getColor(context, R.color.greyishBrown))
    }
}