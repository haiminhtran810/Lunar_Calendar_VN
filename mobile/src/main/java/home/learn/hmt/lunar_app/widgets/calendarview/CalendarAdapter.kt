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
import home.learn.hmt.lunar_app.model.DayMonthYear
import home.learn.hmt.lunar_app.utils.solar2Lunar
import kotlinx.android.synthetic.main.view_calendar_day.view.*
import java.util.*

class CalendarAdapter : BaseAdapter {
    var context: Context? = null
    private var list = ArrayList<Date>()

    constructor(context: Context, list: ArrayList<Date>) : super() {
        this.context = context
        this.list = list
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val today = Date()
        val date = getItem(position)
        val dateCal = Calendar.getInstance()
        dateCal.time = date
        val dateLuna = ChineseCalendar(date)
        val day = dateCal.get(Calendar.DATE)
        val month = date.month
        val year = date.year
        var inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var calendarLayout = inflator.inflate(R.layout.view_calendar_day, parent, false)

        calendarLayout?.apply {
            tv_calendar_day_text.setTypeface(null, Typeface.BOLD)
            tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.black_overlay))
            if (month != today.month || year != today.year) {
                tv_calendar_day_text.setTypeface(null, Typeface.NORMAL)
                tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.warmGreyTwo))
                tv_lunar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.warmGreyTwo))
            } else if (day == today.date) {
                tv_calendar_day_text.setTypeface(null, Typeface.BOLD)
                tv_calendar_day_text.setTextColor(ContextCompat.getColor(context!!, R.color.blu_main))
            }

            tv_calendar_day_text.text = dateLuna.time.date.toString()
            val dmyCalendar = DayMonthYear(day, month, dateCal.get(Calendar.YEAR))
            val dmyLunar = solar2Lunar(dmyCalendar)
            tv_lunar_day_text.text = if (dmyLunar.day == 1) {
                dmyLunar.day.toString() + "/" + dmyLunar.month.toString()
            } else {
                dmyLunar.day.toString()
            }
        }
        return calendarLayout
    }

    override fun getItem(position: Int): Date = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = list.size
}