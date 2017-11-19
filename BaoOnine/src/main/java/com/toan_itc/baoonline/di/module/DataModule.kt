package com.toan_itc.baoonline.di.module

import com.toan_itc.baoonline.data.local.database.RealmManager
import com.toan_itc.baoonline.data.remote.download.DownloadManager
import com.toan_itc.baoonline.library.eventbus.RxBus
import com.toan_itc.core.imageload.FrescoImageLoader
import com.toan_itc.core.imageload.ImageLoaderListener
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton


/**
 * Created by Toan.IT
 * Date: 11/1/2017
 * Email: huynhvantoan.itc@gmail.com
 */
@Module
class DataModule {
    @Provides
    @Singleton
    internal fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SF-UI-Display-Medium.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
    }

    @Singleton
    @Provides
    internal fun realmManager(): RealmManager {
        return RealmManager(downloadManager())
    }

    @Singleton
    @Provides
    internal fun downloadManager(): DownloadManager {
        return DownloadManager()
    }

    @Singleton
    @Provides
    internal fun rxBus(): RxBus {
        return RxBus()
    }

    @Singleton
    @Provides
    internal fun imageLoaderListener(): ImageLoaderListener {
        return FrescoImageLoader()
    }
}
