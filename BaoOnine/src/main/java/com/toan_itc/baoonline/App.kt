package com.toan_itc.baoonline

import com.facebook.drawee.backends.pipeline.Fresco
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.toan_itc.baoonline.data.local.prefs.PreferenceHelper
import com.toan_itc.baoonline.di.applyAutoInjector
import com.toan_itc.core.imageload.ImagePipelineConfigFactory
import dagger.android.support.DaggerApplication
import io.realm.Realm
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import java.net.Proxy
import javax.inject.Inject


class App : DaggerApplication() {
    private var instance: App? = null
    private var mRefWatcher: RefWatcher? = null

    @Inject
    lateinit var mCalligraphyConfig: CalligraphyConfig

    fun getInstance(): App? {
        return instance
    }

    fun getRefWatcher(): RefWatcher? {
        return mRefWatcher
    }

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        applyAutoInjector()
        setupTest()
        setupData()
        initFileDownload()
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

    private fun setupData() {
        CalligraphyConfig.initDefault(mCalligraphyConfig)
        PreferenceHelper.initialize(this,BuildConfig.APP_NAME)
        Realm.init(this)
        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this))
    }

    private fun initFileDownload() {
        FileDownloader.setupOnApplicationOnCreate(this)
                .connectionCreator(FileDownloadUrlConnection.Creator(FileDownloadUrlConnection.Configuration()
                        .connectTimeout(15000)
                        .readTimeout(15000)
                        .proxy(Proxy.NO_PROXY)
                ))
                .commit()
    }

    //Test
    fun setupTest(){
        if (LeakCanary.isInAnalyzerProcess(this)) return
        // init leak canary
        mRefWatcher = LeakCanary.install(this)
    }


}
