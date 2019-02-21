package home.learn.hmt.lunar_app.widgets.listener

import home.learn.hmt.lunar_app.model.CalendarDate

interface OnDateSelectedListener {
    fun onDateSelected(date: CalendarDate)
}