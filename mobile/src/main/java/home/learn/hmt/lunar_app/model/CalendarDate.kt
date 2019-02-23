package home.learn.hmt.lunar_app.model

import java.util.*

data class CalendarDate(
    var mDay: Int = 0,
    var mMonth: Int = 0,
    var mYear: Int = 0
) {

    constructor(calendar: Calendar) : this() {
        calendar.apply {
            mDay = get(Calendar.DAY_OF_WEEK)
            mMonth = get(Calendar.MONTH)
            mYear = get(Calendar.YEAR)
        }
    }

    private fun getCalendar(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(mDay, mMonth, mYear)
        return calendar
    }

    fun getDayOfWeek() = getCalendar().get(Calendar.DAY_OF_WEEK)

    fun isDateEqual(other: CalendarDate): Boolean {
        return mYear == other.mYear &&
                mMonth == other.mMonth &&
                mDay == other.mDay
    }


    private fun getCalender(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(mYear, mMonth, mDay)
        return calendar
    }

    fun addDays(value: Int) {
        val calendar = getCalender()
        calendar.add(Calendar.DATE, value)
        mDay = calendar.get(Calendar.DAY_OF_MONTH)
        mMonth = calendar.get(Calendar.MONTH)
        mYear = calendar.get(Calendar.YEAR)
    }

    override fun toString(): String {
        return "$mDay/$mMonth/$mYear"
    }
}