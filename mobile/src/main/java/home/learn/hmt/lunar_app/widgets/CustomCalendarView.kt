package home.learn.hmt.lunar_app.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.CalendarMonth
import home.learn.hmt.lunar_app.ui.screen.calendar.adapter.CalendarViewPagerAdapter
import home.learn.hmt.lunar_app.widgets.listener.OnDateSelectedListener
import kotlinx.android.synthetic.main.view_custom_calendar.view.*
import java.util.*

class CustomCalendarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var mViewPagerAdapter: CalendarViewPagerAdapter? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_calendar, this)
        buildCalendarView()
    }

    private fun buildCalendarView() {
        val list = ArrayList<CalendarMonth>()
        val today = CalendarMonth(Calendar.getInstance())

        list.add(CalendarMonth(today, -2))
        list.add(CalendarMonth(today, -1))
        list.add(today)
        list.add(CalendarMonth(today, 1))
        list.add(CalendarMonth(today, 2))

        mViewPagerAdapter = CalendarViewPagerAdapter(mViewPager = main_view_pager, mData = list)
        main_view_pager?.apply {
            adapter = mViewPagerAdapter
            addOnPageChangeListener(mPageChangeListener)
            offscreenPageLimit = 1
            currentItem = 1
            tv_main_pager_text_month?.apply {
                text = mViewPagerAdapter!!.getItemPageHeader(2)
            }
        }
    }

    private val mPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            val position = main_view_pager.currentItem
            if (state == ViewPager.SCROLL_STATE_IDLE && position == 1) {
                addPrev()
            }

            if (state == ViewPager.SCROLL_STATE_IDLE && position == mViewPagerAdapter!!.getCount() - 2) {
                addNext()
            }
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPageSelected(position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setOnDateSelectedListener(listener: OnDateSelectedListener) {
        mViewPagerAdapter?.setOnDateSelectedListener(listener)
    }

    private fun addNext() {
        val month = mViewPagerAdapter?.getItem(mViewPagerAdapter!!.getCount() - 1)
        mViewPagerAdapter?.addNext(CalendarMonth(month!!, 1))
    }

    private fun addPrev() {
        val month = mViewPagerAdapter?.getItem(0)
        mViewPagerAdapter?.addPrev(CalendarMonth(month!!, -1))
    }
}