package home.learn.hmt.lunar_app.utils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import home.learn.hmt.lunar_app.model.CalendarDate
import home.learn.hmt.lunar_app.model.DayMonthYear
import java.text.SimpleDateFormat
import java.util.*

fun monthToString(month: Int): String = MONTH[month]

fun dayOfWeekToString(day: Int): String = THU[day]
fun isToday(mYear: Int, mMonth: Int, mDate: Int): Boolean {
    val today = Calendar.getInstance()
    return mYear == today.get(Calendar.YEAR) &&
            mMonth == today.get(Calendar.MONTH) &&
            mDate == today.get(Calendar.DAY_OF_MONTH)
}

fun isDateEqual(date1: CalendarDate, date2: CalendarDate): Boolean {
    return date2.mYear == date2.mYear &&
            date2.mMonth == date2.mMonth &&
            date2.mDay == date2.mDay
}

fun getDayOfWeek(dmy: DayMonthYear): String {
    val dayFormat = dmy.day.toString() + "/" + dmy.month.toString() + "/" + dmy.year.toString()
    val simpleDateFormat = SimpleDateFormat(DD_MM_YYYY)
    val date = simpleDateFormat.parse(dayFormat)
    val day = date.day
    return dayOfWeekToString(day)
}

private fun getPointSize(context: Context): Point {
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}

fun convertHourToChi(hour: Int): String {
    return when (hour) {
        in 1.until(3) -> CHI[1]
        in 3.until(5) -> CHI[2]
        in 5.until(7) -> CHI[3]
        in 7.until(9) -> CHI[4]
        in 9.until(11) -> CHI[5]
        in 11.until(13) -> CHI[6]
        in 13.until(15) -> CHI[7]
        in 15.until(17) -> CHI[8]
        in 17.until(19) -> CHI[9]
        in 19.until(21) -> CHI[10]
        in 21.until(23) -> CHI[11]
        else -> CHI[0]
    }
}

fun Date.convertDataToCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}



