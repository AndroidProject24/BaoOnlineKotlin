package com.toan_itc.baoonline

import android.app.Application


class App:Application(){// : DaggerApplication() {

 /*   override fun applicationInjector() = DaggerAppComponent.builder()
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
*/
}
