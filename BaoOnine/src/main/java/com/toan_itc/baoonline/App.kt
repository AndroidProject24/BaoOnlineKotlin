/*
package com.toan_itc.baoonline

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject


class App : Application(), HasActivityInjector {

    @Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
        if (BuildConfig.DEBUG) {
            //Timber.plant(new Timber.DebugTree());
        }
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
*/
