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

fun getScreenWidth(context: Context): Int {
    return getPointSize(context).x
}

fun getScreenHeight(context: Context): Int {
    return getPointSize(context).y
}

