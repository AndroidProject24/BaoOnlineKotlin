package com.toan_itc.baoonline.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

/*
 * Created by Toan.IT on 10/18/17.
 * Email:Huynhvantoan.itc@gmail.com
 */


abstract class BaseActivityKotlin : DaggerAppCompatActivity(){
    /*@Inject
    internal var navigationController: NavigationController? = null*/
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
