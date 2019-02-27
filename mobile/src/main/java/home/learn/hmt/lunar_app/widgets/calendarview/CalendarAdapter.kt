package home.learn.hmt.lunar_app.widgets.calendarview

import android.content.Context
import android.graphics.Typeface
import android.icu.util.ChineseCalendar
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import home.learn.hmt.lunar_app.R
import kotlinx.android.synthetic.main.view_calendar_day.view.*
import java.util.*

class CalendarAdapter : BaseAdapter {
    var context: Context? = null
    var list = ArrayList<Date>()

    constructor(context: Context, list: ArrayList<Date>) : super() {
        this.context = context
        this.list = list
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val today = Date()
        val date = getItem(position)
        val dateLuna = ChineseCalendar(date)
        val day = date.date
        val month = date.month
        val year = date.year
        var inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var calendarLayout = inflator.inflate(R.layout.view_calendar_day, parent, false)

        calendarLayout.tv_calendar_day_text.setTypeface(null, Typeface.NORMAL)
        calendarLayout.tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.black_overlay))
        if (month != today.month || year != today.year) {
            calendarLayout.tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.warmGreyTwo))
        } else if (day == today.date) {
            calendarLayout.tv_calendar_day_text.setTypeface(null, Typeface.BOLD)
            calendarLayout.tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.blu_main))
        }

        calendarLayout.tv_calendar_day_text.text = dateLuna.time.date.toString()

        return calendarLayout
    }

    override fun getItem(position: Int): Date = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = list.size
}