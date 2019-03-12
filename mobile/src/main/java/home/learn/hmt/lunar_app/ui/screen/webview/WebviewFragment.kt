package home.learn.hmt.lunar_app.ui.screen.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.ui.base.BaseFragment
import home.learn.hmt.lunar_app.utils.gone
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.layout_web_view.*

class WebviewFragment : BaseFragment() {

    private var urlWeb: String? = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_web_view, container, false)
    }

    override fun initView() {
        super.initView()
        urlWeb = arguments?.getString(TAG_URL)
        layout_header.apply {
            img_navigation.setImageResource(R.drawable.ic_arrow_back_black_24dp)
            lg_header_month.gone()
        }

        wv_url.apply {
            settings.apply {
                javaScriptEnabled = true
                builtInZoomControls = true
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
                databaseEnabled = true
            }
            loadUrl(urlWeb)
        }
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
        const val TAG = "WebviewFragment"
        const val TAG_URL = "WebviewFragmentURL"
        fun newInstance(url: String) = WebviewFragment().apply {
            arguments = Bundle().apply {
                putString(TAG_URL, url)
            }
        }
    }
}