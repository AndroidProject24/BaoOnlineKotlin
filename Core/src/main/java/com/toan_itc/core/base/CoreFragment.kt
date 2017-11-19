package com.toan_itc.core.base

import android.os.Bundle
import android.support.v4.app.Fragment


abstract class CoreFragment<T : BaseViewModel> : Fragment(), BaseView {
    lateinit var viewModel: T
        private set


    val coreActivity: CoreActivity
        get() = activity as CoreActivity


    abstract fun setupViewModel(): T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = setupViewModel()
    }
}
