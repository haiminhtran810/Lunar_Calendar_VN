package home.learn.hmt.lunar_app.ui.screen.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.lunar_app.BuildConfig
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.ui.screen.information.InformationFragment
import home.learn.hmt.lunar_app.ui.screen.main.MainFragment
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment() {

    private val handler = Handler()

    private val task = Runnable {
        replaceFragment(MainFragment.newInstance(), MainFragment.TAG)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun initView() {
        super.initView()
        tv_version.text = getString(R.string.beta) + " " + BuildConfig.VERSION_NAME
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(task, DELAY_MILLISECONDS)
    }

    companion object {
        const val TAG = "SplashFragment"
        const val DELAY_MILLISECONDS = 500L
        @JvmStatic
        fun newInstance() = SplashFragment()
    }
}
