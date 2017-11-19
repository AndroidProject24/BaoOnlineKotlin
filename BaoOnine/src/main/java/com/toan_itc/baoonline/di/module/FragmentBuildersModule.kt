package com.toan_itc.baoonline.di.module

import com.toan_itc.baoonline.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
   /* @ContributesAndroidInjector
    internal abstract fun contributeBaseFragment(): CoreFragment
*/
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment
}
