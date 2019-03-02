package home.learn.hmt.lunar_app.ui.screen.main

import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.calendar.CalendarFragment
import home.learn.hmt.lunar_app.ui.screen.information.InformationFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    fun openDrawer(isOpen: Boolean) {
        drawer_layout?.apply {
            if (isOpen) {
                openDrawer(GravityCompat.START)
            } else {
                closeDrawer(GravityCompat.START)
            }
        }

    }

    override fun initView() {
        super.initView()
        nav_view.setNavigationItemSelectedListener(this)
        replaceChildFragment(
            this,
            R.id.container_child,
            InformationFragment.newInstance(),
            InformationFragment.TAG,
            true
        )
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.menu_calendar -> {
                addChildFragment(
                    this,
                    R.id.container_child,
                    CalendarFragment.newInstance(),
                    CalendarFragment.TAG,
                    true
                )
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
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
