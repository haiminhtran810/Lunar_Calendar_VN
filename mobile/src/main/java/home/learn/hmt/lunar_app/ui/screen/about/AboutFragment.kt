package home.learn.hmt.lunar_app.ui.screen.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.lunar_app.BuildConfig
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import kotlinx.android.synthetic.main.layout_header.*
import kotlinx.android.synthetic.main.layout_information_app.*

class AboutFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_information_app, container, false)
    }

    override fun initView() {
        super.initView()
        tv_version.text = getString(R.string.beta) + " " + BuildConfig.VERSION_NAME
    }

    override fun handlers() {
        super.handlers()
        layout_header.apply {
            img_navigation.setImageResource(R.drawable.ic_arrow_back_black_24dp)
            lg_header_month.apply {
                tv_header_month.text = getString(R.string.introduce)
                setBackgroundResource(0)
            }
            img_navigation.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        parentFragment?.let {
            popChildFragment(it)
        }
    }

    companion object {
        const val TAG = "AboutFragment"
        fun newInstance() = AboutFragment()
    }
}