package home.learn.hmt.lunar_app.ui.screen.information


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.DayMonthYear
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.information.adapter.FragmentDayAdapter
import home.learn.hmt.lunar_app.ui.screen.main.MainFragment
import home.learn.hmt.lunar_app.utils.*
import kotlinx.android.synthetic.main.fragment_information.*
import kotlinx.android.synthetic.main.layout_header.*
import kotlinx.android.synthetic.main.layout_header.view.*
import org.greenrobot.eventbus.EventBus
import java.text.SimpleDateFormat
import java.util.*

class InformationFragment : BaseFragment() {
    private var handler: Handler? = null
    private var fragmentDayAdapter: FragmentDayAdapter? = null
    private var dmyCurrent: DayMonthYear? = null
    private var dmyChanger: DayMonthYear? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun initView() {
        super.initView()
        val calendar = Calendar.getInstance()
        dmyCurrent = DayMonthYear(
            calendar.get(Calendar.DAY_OF_MONTH),
            calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR), 0, 0
        )
        handler = Handler()
        dmyCurrent?.let {
            setAdapterDayFragment(dmyCurrent!!)
            printInfo(dmyChanger!!)
        }
        setTime()
    }

    override fun handlers() {
        super.handlers()
        layout_header?.apply {
            img_navigation.setOnClickListener {
                (parentFragment as MainFragment).openDrawer(true)
            }
        }
    }

    fun printInfo(dmy: DayMonthYear) {
        val can = can(dmy)
        val chi = chi(dmy)
        tv_can_chi_date.text = resources.getString(R.string.date) + " " + CAN[can[0]] + " " + CHI[chi[0]]
        tv_can_chi_month.text = resources.getString(
            R.string.month
        ) + " " + CAN[can[1]] + " " + CHI[chi[1]]
        tv_can_chi_year.text = resources.getString(
            R.string.year
        ) + " " + CAN[can[2]] + " " + CHI[chi[2]]
        val lunaDay = solar2Lunar(dmy)
        tv_date_lunar.text = lunaDay.day.toString()
        val hour = gioHoangDao(dmy)
        var hourGold = ""
        hour?.let {
            for (i in it) {
                hourGold += CHI[i] + ", "
            }
            if (!hourGold.isNullOrEmpty()) {
                hourGold = hourGold.substring(0, hourGold.length - 2)
            }
        }
        tv_hour_gold.text = hourGold
        tv_month.text = resources.getString(R.string.month) + " " + lunaDay.month.toString() + "\n - " + lunaDay.year +
                " - "
        tv_header_month.text = resources.getString(
            R.string.month
        ) + " " + dmy.month.toString() + " - " + dmy.year.toString()
        val dayOfWeekData = DayOfWeekData(getDayOfWeek(dmy))
        EventBus.getDefault().post(dayOfWeekData)
    }

    private fun setTime() {
        val time = object : Runnable {
            override fun run() {
                val time = Date(System.currentTimeMillis())
                val hour = convertHourToChi(time.hours)
                val timeFormat = SimpleDateFormat(FORMAT_TIME_24)
                val timeString = timeFormat.format(time.time)
                tv_hour?.apply {
                    text = timeString
                }
                tv_hour_can_chi?.apply {
                    text = resources.getString(R.string.hour) + " " + hour
                }
                handler?.postDelayed(this, 1000)
            }
        }
        handler?.postDelayed(time, 1000)
    }

    private fun setAdapterDayFragment(dmy: DayMonthYear) {
        fragmentManager?.let {
            fragmentDayAdapter = FragmentDayAdapter(this!!.fragmentManager!!, dmy)
        }
        dmyChanger = DayMonthYear(dmy.day, dmy.month, dmy.year, 0, 0)
        fragmentDayAdapter?.let {
            view_page.apply {
                adapter = fragmentDayAdapter
                currentItem = dmyChanger!!.day
                addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {
                    }

                    override fun onPageScrolled(
                        position: Int, positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {
                    }

                    override fun onPageSelected(position: Int) {
                        dmyChanger?.apply {
                            day = position
                            if (position - 1 == maxDayOfMonth(month, year)) {
                                dmyChanger = addDay(dmyChanger!!, 1)
                                fragmentDayAdapter = FragmentDayAdapter(
                                    fragmentManager!!,
                                    dmyChanger!!
                                )
                                fragmentDayAdapter!!.notifyDataSetChanged()
                                adapter = fragmentDayAdapter
                                currentItem = 1
                            }

                            if (position == 0) {
                                dmyChanger = addDay(dmyChanger!!, -1)
                                fragmentDayAdapter = FragmentDayAdapter(
                                    fragmentManager!!,
                                    dmyChanger!!
                                )
                                fragmentDayAdapter!!.notifyDataSetChanged()
                                adapter = fragmentDayAdapter
                                currentItem = maxDayOfMonth(dmyChanger!!.month, dmyChanger!!.year)
                            }
                            printInfo(dmyChanger!!)
                        }
                    }
                })
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        activity?.onBackPressed()
    }

    companion object {
        const val TAG = "InformationFragment"
        @JvmStatic
        fun newInstance() = InformationFragment()
    }

    data class DayOfWeekData(val day: String)
}
