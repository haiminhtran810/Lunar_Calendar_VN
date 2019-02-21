package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.GridLayout
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.CalendarDate
import home.learn.hmt.lunar_app.model.CalendarMonth
import home.learn.hmt.lunar_app.utils.NUMBER_OF_DAYS_IN_WEEK
import home.learn.hmt.lunar_app.utils.NUMBER_OF_WEEKS_IN_MONTH
import home.learn.hmt.lunar_app.utils.getScreenWidth
import home.learn.hmt.lunar_app.widgets.listener.OnDayViewClickListener
import kotlinx.android.synthetic.main.view_calendar_month.view.*

class CalendarMonthView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), View.OnClickListener {

    var mSelectedDate: CalendarDate? = null

    var mListener: OnDayViewClickListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_calendar_month, this)
    }

    fun buildView(calendarMonth: CalendarMonth) {
        val row = NUMBER_OF_WEEKS_IN_MONTH
        val col = NUMBER_OF_DAYS_IN_WEEK
        view_calendar_month_grid.rowCount = row
        view_calendar_month_grid.columnCount = col
        val screenWith = getScreenWidth(context)
        val width = screenWith / col
        for (date in calendarMonth.mDays) {
            val param = GridLayout.LayoutParams()
            param.width = width
            param.height = LayoutParams.WRAP_CONTENT

            val dayView = CalendarDayView(context, date)
            dayView.contentDescription = date.toString()
            dayView.layoutParams = param
            dayView.setOnClickListener(this)
            decorateDayView(dayView, date, calendarMonth.mMonth)
            view_calendar_month_grid.addView(dayView)
        }
    }

    private fun decorateDayView(dayView: CalendarDayView, day: CalendarDate, month: Int) {
        if (day.mMonth !== month) {
            dayView.setOtherMothTextColor()
        } else {
            dayView.setThisMothTextColor()
        }

        if (mSelectedDate != null && mSelectedDate!!.isDateEqual(day)) {
            dayView.setPurpleSolidOvalBackground()
        } else {
            dayView.unsetPurpleSolidOvalBackground()
        }
    }

    override fun onClick(p0: View?) {
        mListener?.apply {
            p0?.let {
                onDayViewClick((it as CalendarDayView))
            }

        }
    }
}