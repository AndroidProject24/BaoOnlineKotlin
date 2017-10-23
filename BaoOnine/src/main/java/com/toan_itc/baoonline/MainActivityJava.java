package com.toan_itc.baoonline;

import com.toan_itc.baoonline.base.BaseActivity;

/**
 * Created by Toan.IT on 10/23/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

public class MainActivityJava extends BaseActivity {
    @Override
    public int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        if(navigationController!=null)
        navigationController.navigateToMain();
    }

    @Override
    public void initData() {

    }
}
