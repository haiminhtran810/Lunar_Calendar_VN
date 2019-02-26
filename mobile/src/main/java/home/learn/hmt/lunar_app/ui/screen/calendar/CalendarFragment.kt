package home.learn.hmt.lunar_app.ui.screen.calendar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.main.MainFragment
import home.learn.hmt.lunar_app.widgets.calendarview.CalendarView
import kotlinx.android.synthetic.main.fragment_calendar.*
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
        layout_header.apply {
            lg_header_month.apply {
                tv_header_month.text = getString(R.string.nav_calendar)
                img_arrow.visibility = View.GONE
            }
            img_navigation.setOnClickListener {
                (parentFragment as MainFragment).openDrawer(true)
            }
        }
        cv_calendar.setEventHandler(object : CalendarView.EventHandler {
            override fun onDayPress(date: Date) {
                Toast.makeText(requireActivity(), date.day.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

    companion object {
        const val TAG = "CalendarFragment"
        fun newInstance() = CalendarFragment()
    }
}
