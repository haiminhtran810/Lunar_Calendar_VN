package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.CalendarDate
import kotlinx.android.synthetic.main.view_calendar_day.view.*

class CalendarDayView @JvmOverloads constructor(
    context: Context, calendarDate: CalendarDate, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var mCalendarDate = calendarDate

    init {
        LayoutInflater.from(context).inflate(R.layout.view_calendar_day, this)
        calendarDate?.apply {
            tv_calendar_day_text.text = mDay.toString()
        }
    }

    fun setThisMothTextColor() {
        tv_calendar_day_text.setTextColor(ContextCompat.getColor(context, R.color.lightNavy))
    }

    fun setOtherMothTextColor() {
        tv_calendar_day_text.setTextColor(ContextCompat.getColor(context, R.color.warmGreyTwo))
    }

    fun setPurpleSolidOvalBackground() {
        //bg_day.setBackgroundResource(R.drawable.oval_purple_solid)
    }

    fun unsetPurpleSolidOvalBackground() {
        //bg_day.setBackgroundResource(R.drawable.oval_black_solid)
    }
}