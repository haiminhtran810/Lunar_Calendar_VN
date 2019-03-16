package home.learn.hmt.lunar_app.ui.screen.webview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.utils.slideContentStar
import home.learn.hmt.lunar_app.utils.slideDateStar
import home.learn.hmt.lunar_app.utils.slideImagesStar
import kotlinx.android.synthetic.main.item_star.view.*


//http://lichvansu.wap.vn/tu-vi-hang-thang-12-cung-hoang-dao.html

class SliderAdapter(context: Context) : PagerAdapter() {
    var context = context

    lateinit var layoutInflater: LayoutInflater
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ScrollView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_star, container, false)
        view?.apply {
            tv_date_star.text = slideDateStar()[position]
            img_slide.setImageResource(slideImagesStar()[position])
            tv_content_star.text = slideContentStar()[position]
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ScrollView)
    }

    override fun getCount(): Int = slideDateStar().size
}