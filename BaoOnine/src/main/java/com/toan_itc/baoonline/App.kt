package com.toan_itc.baoonline

import com.toan_itc.baoonline.di.applyAutoInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration


class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
        if (BuildConfig.DEBUG) {
            //Timber.plant(new Timber.DebugTree());
        }
    }

}
