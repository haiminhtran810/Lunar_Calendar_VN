package home.learn.hmt.lunar_app.widgets.calendarview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.LinearLayout
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.utils.DATE_FORMAT
import home.learn.hmt.lunar_app.utils.DAYS_COUNT
import home.learn.hmt.lunar_app.utils.YYYY
import kotlinx.android.synthetic.main.control_calendar.view.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class CalendarView : LinearLayout {
    private var inflater: LayoutInflater? = null
    private var dateFormat: String? = null
    private val currentDate = Calendar.getInstance()
    private val formatter = SimpleDateFormat(YYYY, Locale.ENGLISH)
    private var rainbow = intArrayOf(R.color.summer, R.color.fall, R.color.winter, R.color.spring)
    private var monthSeason = intArrayOf(2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1, 2)
    private var eventHandler: EventHandler? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initControl(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initControl(context, attrs)
    }

    /*
    Some Logic is Needed

    To make this component actually behave as a calendar view, some business logic is in order. It might seem complicated at first, but there is really not much to it. Let’s break it down:

    The calendar view is seven days wide, and it is guaranteed that all months will start somewhere in the first row.
    First, we need to figure out what position the month starts at, then fill all the positions before that with the numbers from the previous month (30, 29, 28.. etc.) until we reach position 0.
    Then, we fill out the days for the current month (1, 2, 3… etc).
    After that come the days for the next month (again, 1, 2, 3.. etc), but this time we only fill the remaining positions in the last row(s) of the grid. */

    private fun initControl(context: Context?, attrs: AttributeSet) {
        inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater?.inflate(R.layout.control_calendar, this)
        loadDateFormat(attrs)
        assignClickHandlers()
        updateCalendar()
    }

    private fun loadDateFormat(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CalendarView)
        try {
            // try to load provided date format, and fallback to default otherwise
            dateFormat = ta.getString(R.styleable.CalendarView_dateFormat)
            if (dateFormat == null)
                dateFormat = DATE_FORMAT
        } finally {
            ta.recycle()
        }
    }

    fun updateCalendar() {
        try {
            var cells = ArrayList<Date>()
            var calendar = currentDate.clone() as Calendar
            //var lunaCalendar = lunaDate.clone() as Calendar
            // determine the cell for current month's beginning
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            val monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1
            // move calendar backwards to the beginning of the week
            calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell)
            while (cells.size < DAYS_COUNT) {
                cells.add(calendar.time)
                calendar.add(Calendar.DAY_OF_MONTH + 1, 1)
            }
            calendar_grid.adapter = CalendarAdapter(context, cells)
            val month = currentDate.get(Calendar.MONTH)
            val season = monthSeason[month]
            val color = rainbow[season]
            calendar_date_display.text = resources.getStringArray(R.array.month)[month] + " - " +
                    formatter.format(currentDate.time)
            calendar_header.setBackgroundColor(resources.getColor(color))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun assignClickHandlers() {
        calendar_next_button.setOnClickListener {
            currentDate.add(Calendar.MONTH, 1)
            updateCalendar()
        }

        calendar_prev_button.setOnClickListener {
            currentDate.add(Calendar.MONTH, -1)
            updateCalendar()
        }

        calendar_grid.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            val dateContent = parent?.getItemAtPosition(position) as Date
            eventHandler?.apply {
                onDayPress(dateContent)
            }
        }

        calendar_grid.setOnTouchListener(object : OnSwipeTouchListener(context) {
            override fun onSwipeLeft() {
                currentDate.add(Calendar.MONTH, 1)
                updateCalendar()
                super.onSwipeLeft()
            }

            override fun onSwipeRight() {
                currentDate.add(Calendar.MONTH, -1)
                updateCalendar()
                super.onSwipeRight()
            }
        })
    }

    interface EventHandler {
        fun onDayPress(date: Date)
    }

    fun setEventHandler(eventHandler: EventHandler) {
        this.eventHandler = eventHandler
    }
}