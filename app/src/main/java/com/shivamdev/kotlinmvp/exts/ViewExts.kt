package com.shivamdev.kotlinmvp.exts

import android.view.View

/**
 * Created by shivam on 09/02/18.
 */

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}