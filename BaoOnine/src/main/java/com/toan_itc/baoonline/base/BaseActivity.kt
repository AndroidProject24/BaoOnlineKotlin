package com.toan_itc.baoonline.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Toan.IT on 10/18/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

abstract class BaseActivity : AppCompatActivity(),HasSupportFragmentInjector{

    @Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null
    /*@Inject
    internal var navigationController: NavigationController? = null
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResourceID())
        initViews()
        initData()
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    abstract @LayoutRes internal fun setLayoutResourceID(): Int

    abstract fun initViews()

    abstract fun initData()
}