package com.toan_itc.baoonline

import com.facebook.drawee.backends.pipeline.Fresco
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.toan_itc.baoonline.di.DaggerAppComponent
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
        setupRealm()
        if (BuildConfig.DEBUG) {
            setupLogger()
        }
    }

    private fun setupLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(getString(R.string.app_name))
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private fun setupRealm(){
        Fresco.initialize(this);
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
    }
}
