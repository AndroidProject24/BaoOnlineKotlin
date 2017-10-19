package com.toan_itc.core.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by Toan.IT on 10/18/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResourceID())
        initViews()
        initData()
    }

    abstract @LayoutRes internal fun setLayoutResourceID(): Int

    abstract fun initViews()

    abstract fun initData()
}