package com.toan_itc.baoonline.di.component

import com.toan_itc.baoonline.App
import com.toan_itc.baoonline.di.module.ActivityBuildersModule
import com.toan_itc.baoonline.di.module.DataModule
import com.toan_itc.baoonline.di.module.NetworkModule
import com.toan_itc.baoonline.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, NetworkModule::class, DataModule::class, ActivityBuildersModule::class, ViewModelModule::class))
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}
