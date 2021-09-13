package com.tochapps.ceibatestapp.base

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.tochapps.ceibatestapp.ui.view.Loading


abstract class BaseActivity : AppCompatActivity() {

    private var loadingBar: Loading? = null

    /**
     * Loading
     */

    private fun initLoading() {
        if (loadingBar == null) {
            loadingBar = Loading(this)
            addContentView(loadingBar,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    protected open fun showLoading(showing: Boolean = true ) {
        initLoading()
        if (showing) {
            loadingBar?.showProgressBar()
        } else {
            loadingBar?.hideProgressBar()
        }
    }
}