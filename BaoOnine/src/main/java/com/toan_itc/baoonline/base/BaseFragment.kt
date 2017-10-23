package com.toan_itc.baoonline.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toan_itc.baoonline.di.Injectable

/**
 * Created by Toan.IT on 10/18/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

abstract class BaseFragment : Fragment(), Injectable {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (setLayoutResourceID() != 0 && inflater!=null) {
            inflater.inflate(setLayoutResourceID(), container, false)
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }

    abstract @LayoutRes internal fun setLayoutResourceID(): Int

    abstract fun initViews()

    abstract fun initData()
}