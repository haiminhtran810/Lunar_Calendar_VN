package home.learn.hmt.lunar_app.ui.screen.calendar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.CalendarDate
import home.learn.hmt.lunar_app.widgets.listener.OnDateSelectedListener

class CalendarFragment : Fragment(), OnDateSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onDateSelected(date: CalendarDate) {
        Toast.makeText(context, date.toString(), Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TAG = "CalendarFragment"
        fun newInstance() = CalendarFragment()
    }
}
