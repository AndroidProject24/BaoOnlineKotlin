package com.toan_itc.baoonline.ui.main

import com.toan_itc.baoonline.R
import com.toan_itc.baoonline.base.BaseFragment

/**
 * Created by Toan.IT on 10/22/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
public class MainFragment :BaseFragment(){
    companion object {
        @JvmStatic
        fun create(): MainFragment {
            return MainFragment()
        }
    }
    override fun setLayoutResourceID(): Int {
       return R.layout.activity_test
    }
    override fun initViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}