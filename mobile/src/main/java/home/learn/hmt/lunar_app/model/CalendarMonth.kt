package home.learn.hmt.lunar_app.model

data class CalendarMonth(
    val mMonth: Int,
    val mYear: Int,
    val mDays: List<CalendarDate>
)