package home.learn.hmt.lunar_app.model

import java.util.*

data class CalendarDate(
    val mDay: Int,
    val mMonth: Int,
    val mYear: Int
) {
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
}