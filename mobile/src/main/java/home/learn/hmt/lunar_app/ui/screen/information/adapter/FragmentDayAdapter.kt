package home.learn.hmt.lunar_app.ui.screen.information.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import home.learn.hmt.lunar_app.model.DayMonthYear
import home.learn.hmt.lunar_app.ui.screen.information.day.DayFragment
import home.learn.hmt.lunar_app.utils.maxDayOfMonth

class FragmentDayAdapter(
    private val fm: FragmentManager,
    private val dmy: DayMonthYear
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return DayFragment.newInstance(position, dmy)
    }

    override fun getCount(): Int {
        return (maxDayOfMonth(dmy.month, dmy.year) + 2)
    }
}