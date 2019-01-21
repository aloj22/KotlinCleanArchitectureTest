package com.ninetyninetest.app.ui

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ninetyninetest.presentation.base.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {


    /**
     * Handles error
     * @param error
     */
    override fun handleError(error: String?) {
        Toast.makeText(this, error ?: "", Toast.LENGTH_SHORT).show()
    }

}