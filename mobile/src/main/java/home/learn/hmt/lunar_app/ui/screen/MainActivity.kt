package home.learn.hmt.lunar_app.ui.screen

import android.os.Bundle
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseActivity
import home.learn.hmt.lunar_app.ui.screen.splash.SplashFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SplashFragment.newInstance(), SplashFragment.TAG).commitNow()
        }
    }
}
