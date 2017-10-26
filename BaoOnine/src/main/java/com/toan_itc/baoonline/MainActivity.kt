package com.toan_itc.baoonline

import com.toan_itc.baoonline.base.BaseActivity
import com.toan_itc.baoonline.ui.home.Test1Fragment
import com.toan_itc.core.utils.setContentFragment

class MainActivity : BaseActivity() {

    override fun initViews() {
        setContentFragment(R.id.container){ Test1Fragment.newInstance() }
    }

    override fun initData() {

    }

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_main
    }
}
