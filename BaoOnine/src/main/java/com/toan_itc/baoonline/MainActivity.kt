package com.toan_itc.baoonline

import com.toan_itc.baoonline.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
        //setContentFragment(R.id.container){ Test1Fragment.newInstance() }
    }

    override fun initData() {

    }

}
