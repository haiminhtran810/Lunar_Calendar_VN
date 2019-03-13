package home.learn.hmt.lunar_app.ui.screen.main

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.material.navigation.NavigationView
import home.learn.hmt.lunar_app.BuildConfig

import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.about.AboutFragment
import home.learn.hmt.lunar_app.ui.screen.calendar.CalendarFragment
import home.learn.hmt.lunar_app.ui.screen.information.InformationFragment
import home.learn.hmt.lunar_app.ui.screen.webview.WebviewFragment
import home.learn.hmt.lunar_app.utils.URL_12_STAR
import home.learn.hmt.lunar_app.utils.URL_SHARE_FACEBOOK
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_nav_head.view.*

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        nav_view.apply {
            itemIconTintList = null
            val hView = getHeaderView(0)
            hView.tv_version.text = getString(R.string.beta) + " " + BuildConfig.VERSION_NAME
        }

    }

    override fun initView() {
        super.initView()
        loadAds()
        nav_view.setNavigationItemSelectedListener(this)
        replaceChildFragment(
            this,
            R.id.container_child,
            InformationFragment.newInstance(),
            InformationFragment.TAG,
            true
        )

    }

    private fun loadAds() {
        adView.apply {
            val adRequest = AdRequest.Builder().build()
            loadAd(adRequest)
        }
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
            R.id.menu_12_cung -> {
                addChildFragment(
                    this,
                    R.id.container_child,
                    WebviewFragment.newInstance(URL_12_STAR),
                    WebviewFragment.TAG,
                    true
                )
            }
            R.id.menu_share -> {
                shareFacebook()
            }
            R.id.menu_about -> {
                addChildFragment(
                    this,
                    R.id.container_child,
                    AboutFragment.newInstance(),
                    AboutFragment.TAG,
                    true
                )
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun shareFacebook() {
        val urlShare = URL_SHARE_FACEBOOK + context?.packageName
        context?.let {
            Intent(Intent.ACTION_SEND)?.apply {
                putExtra(Intent.EXTRA_TEXT, urlShare)
                type = "text/plain"
                startActivity(Intent.createChooser(this, "share"))
            }
        }
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
}
