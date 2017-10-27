package com.toan_itc.baoonline

import com.facebook.drawee.backends.pipeline.Fresco
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.toan_itc.baoonline.db.Migration
import com.toan_itc.baoonline.di.applyAutoInjector
import com.toan_itc.baoonline.utils.Constants
import com.toan_itc.core.imageload.ImagePipelineConfigFactory
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
        initFresco()
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
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Constants.BaoOnline_Realm)
                .schemaVersion(Constants.RealmVersion)
                .deleteRealmIfMigrationNeeded()
                .migration(Migration())
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun initFresco() {
        Fresco.initialize(this,ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this))
    }

}
