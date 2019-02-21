package home.learn.hmt.lunar_app.model

import java.util.*

data class CalendarDate(
    var mDay: Int,
    var mMonth: Int,
    var mYear: Int
) {

    fun setCalendar(calendar: Calendar) {
        calendar?.apply {
            mDay = get(Calendar.DAY_OF_WEEK)
            mMonth = get(Calendar.MONTH)
            mYear = get(Calendar.YEAR)
        }
    }

    fun getCalendar(): Calendar {
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


    override fun toString(): String {
        return "$mDay/$mMonth/$mYear"
    }
}