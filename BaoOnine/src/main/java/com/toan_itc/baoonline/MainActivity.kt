package com.toan_itc.baoonline

import android.os.Bundle
import com.toan_itc.baoonline.ui.home.HomeFragment

class MainActivity : BaseActivity() {

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_main
    }

    override fun initViews(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            addFragment(HomeFragment.newInstance(), R.id.container)
        /* addFragment(fragment, R.id.fragment_container)
         replaceFragment(fragment, R.id.fragment_container)*/
    }

    override fun initData() {

    }

}
