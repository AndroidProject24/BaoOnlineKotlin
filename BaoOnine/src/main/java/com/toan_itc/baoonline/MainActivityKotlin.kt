package com.toan_itc.baoonline

import com.toan_itc.baoonline.base.BaseActivityKotlin
import com.toan_itc.baoonline.ui.main.MainFragment

class MainActivityKotlin : BaseActivityKotlin(){
    override fun initViews() {
        val fragment = MainFragment.create()
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, "Test")
                .addToBackStack(null)
                .commitAllowingStateLoss()
        //navigationController?.navigateToMain()
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_main
    }
}
