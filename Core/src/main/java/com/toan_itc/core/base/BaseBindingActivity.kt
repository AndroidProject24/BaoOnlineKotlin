package com.toan_itc.core.base

import android.os.Bundle
import android.view.LayoutInflater


abstract class BaseBindingActivity<T : BaseViewModel, B : ViewDataBinding> : CoreActivity(), BaseView {
    var viewModel: T? = null
        private set
    lateinit var binding: B
        private set

    abstract fun setupViewModel(): T
    abstract fun inflateBindingLayout(inflater: LayoutInflater): B


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = setupViewModel()
        binding = setupBinding(layoutInflater)
        setContentView(binding.root)
    }


    private fun setupBinding(inflater: LayoutInflater): B {
        val binding = inflateBindingLayout(inflater)
        binding.setVariable(BR.view, this)
        binding.setVariable(BR.viewModel, viewModel)
        return binding
    }
}
