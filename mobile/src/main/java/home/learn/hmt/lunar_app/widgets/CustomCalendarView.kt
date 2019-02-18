package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class CustomCalendarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    interface DayClickListener {
        fun onDayClick()
    }
}