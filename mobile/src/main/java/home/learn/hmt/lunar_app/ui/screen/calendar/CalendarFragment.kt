package home.learn.hmt.lunar_app.ui.screen.calendar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.DayMonthYear
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.main.MainFragment
import home.learn.hmt.lunar_app.utils.CAN
import home.learn.hmt.lunar_app.utils.CHI
import home.learn.hmt.lunar_app.utils.can
import home.learn.hmt.lunar_app.utils.chi
import home.learn.hmt.lunar_app.widgets.calendarview.CalendarView
import kotlinx.android.synthetic.main.fragment_calendar.*
import kotlinx.android.synthetic.main.layout_can_chi_information.*
import kotlinx.android.synthetic.main.layout_can_chi_information.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import java.util.*

class CalendarFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun initView() {
        super.initView()
        val cal = Calendar.getInstance()
        tv_Calendar.text = cal.convertToString()

        printInforCanChi(DayMonthYear(cal.get(Calendar.DATE), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR)))
    }

    private fun printInforCanChi(dayMonthYear: DayMonthYear) {
        val can = can(dayMonthYear)
        val chi = chi(dayMonthYear)
        tv_Luna_day.text = CAN[can[0]] + " " + CHI[chi[0]]
        tv_Luna_month.text = CAN[can[1]] + " " + CHI[chi[1]]
        tv_Luna_year.text = CAN[can[2]] + " " + CHI[chi[2]]
    }


    override fun handlers() {
        super.handlers()
        layout_header.apply {
            img_navigation.setImageResource(R.drawable.ic_arrow_back_black_24dp)
            lg_header_month.apply {
                tv_header_month.text = getString(R.string.nav_calendar)
                img_arrow.visibility = View.GONE
            }
            img_navigation.setOnClickListener {
                onBackPressed()
            }
        }
        cv_calendar.setEventHandler(object : CalendarView.EventHandler {
            override fun onDayPress(cal: Calendar) {
                layout_can_chi_information?.apply {
                    tv_Calendar.text = cal.convertToString()
                    printInforCanChi(
                        DayMonthYear(
                            cal.get(Calendar.DATE),
                            cal.get(Calendar.MONTH) + 1,
                            cal.get(Calendar.YEAR)
                        )
                    )
                }
            }
        })
    }

    override fun onBackPressed() {
        parentFragment?.let {
            popChildFragment(it)
        }
    }

    companion object {
        const val TAG = "CalendarFragment"
        fun newInstance() = CalendarFragment()
    }

    fun Calendar.convertToString(): String {
        var dayOfWeek = if (this.get(Calendar.DAY_OF_WEEK) == 1) {
            getString(R.string.sunday)
        } else {
            getString(R.string.day) + " " + this.get(Calendar.DAY_OF_WEEK)
        }
        return dayOfWeek + " - " + getString(R.string.date) + " " + this.get(Calendar.DATE) + " - " +
                getString(R.string.month) + " " + (this.get(Calendar.MONTH) + 1) + " -" +
                getString(R.string.year) + " " + this.get(Calendar.YEAR)
    }
}
