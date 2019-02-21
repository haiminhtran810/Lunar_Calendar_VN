package home.learn.hmt.lunar_app.ui.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.calendar.CalendarFragment
import home.learn.hmt.lunar_app.ui.screen.information.InformationFragment

class MainFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun initView() {
        super.initView()
        replaceChildFragment(this, R.id.container_child, CalendarFragment.newInstance(), CalendarFragment.TAG)
    }

    companion object {
        const val TAG = "MainFragment"
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
