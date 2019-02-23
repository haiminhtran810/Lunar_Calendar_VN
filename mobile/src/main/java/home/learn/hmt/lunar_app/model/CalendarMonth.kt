package home.learn.hmt.lunar_app.model

import home.learn.hmt.lunar_app.utils.NUMBER_OF_DAYS_IN_WEEK
import home.learn.hmt.lunar_app.utils.NUMBER_OF_WEEKS_IN_MONTH
import java.util.*
import kotlin.collections.ArrayList

data class CalendarMonth(
    var mMonth: Int = 0,
    var mYear: Int = 0,
    var mDays: MutableList<CalendarDate> = ArrayList()
) {

    constructor(calendar: Calendar) : this() {
        mMonth = calendar.get(Calendar.MONTH)
        mYear = calendar.get(Calendar.YEAR)
        createMonthDays()
    }

    constructor(other: CalendarMonth, value: Int) : this() {
        val calendar = Calendar.getInstance()
        calendar.set(other.mYear, other.mMonth, 1)
        calendar.add(Calendar.MONTH, value)

        mMonth = calendar.get(Calendar.MONTH)
        mYear = calendar.get(Calendar.YEAR)
        createMonthDays()
    }

    private fun createMonthDays() {
        val date = CalendarDate(1, mMonth, mYear)
        val dayOfWeek = date.getDayOfWeek()
        date.addDays(1 - dayOfWeek)
        for (i in 1..NUMBER_OF_DAYS_IN_WEEK * NUMBER_OF_WEEKS_IN_MONTH) {
            val day = CalendarDate(date.mDay, date.mMonth, date.mYear)
            mDays?.apply {
                add(day)
            }
            date.addDays(1)
        }
    }

    fun getDays() = mDays

    override fun toString(): String {
        return "$mMonth     $mYear"
    }
}