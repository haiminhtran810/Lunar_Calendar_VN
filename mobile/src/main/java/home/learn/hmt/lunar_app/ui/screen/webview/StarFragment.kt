package home.learn.hmt.lunar_app.ui.screen.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.layout_web_view.*


//Github: https://github.com/tommybuonomo/dotsindicator
class StarFragment : BaseFragment() {

    private var urlWeb: String? = ""
    private var adapter: SliderAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_web_view, container, false)
    }

    override fun initView() {
        super.initView()
        context?.apply {
            adapter = SliderAdapter(this)
            slideViewPager.adapter = adapter
            dots_indicator.setViewPager(slideViewPager)
        }


        urlWeb = arguments?.getString(TAG_URL)
        layout_header.apply {
            img_navigation.setImageResource(R.drawable.ic_arrow_back_black_24dp)
            lg_header_month.setBackgroundResource(0)
            tv_header_month.text = getString(R.string.nav_12_cung)
        }

        /*wv_url.apply {
            settings.apply {
                javaScriptEnabled = true
                builtInZoomControls = true
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
                databaseEnabled = true
            }
            loadUrl(urlWeb)
        }*/
    }

    override fun handlers() {
        super.handlers()
        layout_header.apply {
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
        const val TAG = "StarFragment"
        const val TAG_URL = "WebviewFragmentURL"
        fun newInstance(url: String) = StarFragment().apply {
            arguments = Bundle().apply {
                putString(TAG_URL, url)
            }
        }
    }
}