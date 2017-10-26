package com.toan_itc.baoonline.di

import com.toan_itc.baoonline.base.BaseFragment
import com.toan_itc.baoonline.ui.home.Test1Fragment
import com.toan_itc.baoonline.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    internal abstract fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    internal abstract fun contributeTest1Fragment(): Test1Fragment
}
