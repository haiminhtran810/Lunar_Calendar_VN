package home.learn.hmt.lunar_app.ui.screen.calendar.adapter

import android.view.View
import android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import home.learn.hmt.lunar_app.model.CalendarDate
import home.learn.hmt.lunar_app.model.CalendarMonth
import home.learn.hmt.lunar_app.widgets.CalendarDayView
import home.learn.hmt.lunar_app.widgets.CalendarMonthView
import home.learn.hmt.lunar_app.widgets.listener.OnDateSelectedListener
import home.learn.hmt.lunar_app.widgets.listener.OnDayViewClickListener
import java.util.*

class CalendarViewPagerAdapter @JvmOverloads constructor(
    val mViewPager: ViewPager,
    val mData: MutableList<CalendarMonth>
) :
    PagerAdapter(), OnDayViewClickListener {
    private var mSelectedDate: CalendarDate? = null
    private var mListener: OnDateSelectedListener? = null

    init {
        val mDate = Calendar.getInstance()
        mSelectedDate = CalendarDate(mDate)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val month = mData[position]
        val monthView = CalendarMonthView(container.context)
        monthView.mSelectedDate = mSelectedDate
        monthView.mListener = this
        monthView.buildView(month)
        (container).addView(monthView, 0)
        monthView.tag = month
        return monthView
    }

    override fun onDayViewClick(view: CalendarDayView) {
        // unset old selection
        decorateSelection(mSelectedDate.toString(), false)

        // set new selection
        mSelectedDate = view.mCalendarDate
        decorateSelection(mSelectedDate.toString(), true)

        if (mListener != null) {
            mSelectedDate?.apply {
                mListener!!.onDateSelected(CalendarDate(mDay, mMonth, mYear))
            }

        }
    }

    private fun decorateSelection(tag: String, isSelected: Boolean) {
        val output = ArrayList<View>()
        mViewPager.findViewsWithText(output, tag, FIND_VIEWS_WITH_CONTENT_DESCRIPTION)
        for (outputView in output) {
            val dayView = outputView as CalendarDayView
            if (isSelected) {
                dayView.setPurpleSolidOvalBackground()
            } else {
                dayView.unsetPurpleSolidOvalBackground()
            }

        }
    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = mData.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getItemPosition(`object`: Any): Int {
        val view = `object` as View
        val month = view.tag as CalendarMonth

        val position = mData.indexOf(month)
        return if (position >= 0) {
            position
        } else {
            POSITION_NONE
        }
    }

    fun addNext(month: CalendarMonth) {
        mData.add(month)
        notifyDataSetChanged()
    }

    fun addPrev(month: CalendarMonth) {
        mData.add(0, month)
        notifyDataSetChanged()
    }

    fun getItemPageHeader(position: Int): String {
        return mData[position].toString()
    }

    fun getItem(position: Int): CalendarMonth {
        return mData[position]
    }

    fun setOnDateSelectedListener(listener: OnDateSelectedListener) {
        mListener = listener

        if (mListener != null) {
            mSelectedDate?.apply {
                mListener!!.onDateSelected(CalendarDate(mDay, mMonth, mYear))
            }
        }
    }
}