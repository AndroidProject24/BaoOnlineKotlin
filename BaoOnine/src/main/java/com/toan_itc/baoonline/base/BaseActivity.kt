package com.toan_itc.baoonline.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/*
 * Created by Toan.IT on 10/18/17.
 * Email:Huynhvantoan.itc@gmail.com
 */


abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = androidInjector

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
