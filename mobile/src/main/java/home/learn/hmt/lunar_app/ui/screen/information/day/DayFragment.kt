package home.learn.hmt.lunar_app.ui.screen.information.day

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.DayMonthYear
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.information.InformationFragment
import home.learn.hmt.lunar_app.utils.IMAGE_FOX
import home.learn.hmt.lunar_app.utils.folks
import home.learn.hmt.lunar_app.utils.getDayOfWeek
import kotlinx.android.synthetic.main.fragment_day.*
import kotlinx.android.synthetic.main.layout_fox.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.*

class DayFragment : BaseFragment() {

    private var dayOfWeekString: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun initView() {
        super.initView()
        arguments?.apply {
            val day = getInt(TAG, 0)
            val dayOfWeek = getString(TAG_DMY)
            updateUI(day, dayOfWeek)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onEvent(dayOfWeekData: InformationFragment.DayOfWeekData) {
        dayOfWeekString = dayOfWeekData.day
        tv_day_of_week.text = dayOfWeekString
    }

    private fun updateUI(day: Int, dayOfWeek: String) {
        tv_date_information.text = day.toString()
        if (dayOfWeekString.isNullOrBlank()) {
            tv_day_of_week.text = dayOfWeek
        } else {
            tv_day_of_week.text = dayOfWeekString
        }
        lg_fox.apply {
            txt_fox?.text = folks[Random().nextInt(folks.size)]
        }
        //img_bg_calendar.setImageResource(IMAGE_FOX[Random().nextInt(IMAGE_FOX.size)])
    }

    companion object {
        const val TAG = "FragmentDay"
        const val TAG_DMY = "FragmentDayDMY"
        fun newInstance(day: Int, dmy: DayMonthYear) =
            DayFragment().apply {
                arguments = Bundle().apply {
                    val dayOfWeek = getDayOfWeek(dmy)
                    putInt(TAG, day)
                    putString(TAG_DMY, dayOfWeek)
                }
            }
    }
}
