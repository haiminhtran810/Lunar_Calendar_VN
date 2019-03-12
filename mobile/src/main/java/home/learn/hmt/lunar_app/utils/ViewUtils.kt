package home.learn.hmt.lunar_app.utils

import android.view.View

fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

fun View.isInvisible(): Boolean {
    return this.visibility == View.INVISIBLE
}

fun View.visible() {
    if (isVisible().not()) this.visibility = View.VISIBLE
}

fun View.invisible() {
    if (isInvisible().not()) this.visibility = View.INVISIBLE
}

fun View.gone() {
    if (isGone().not()) this.visibility = View.GONE
}