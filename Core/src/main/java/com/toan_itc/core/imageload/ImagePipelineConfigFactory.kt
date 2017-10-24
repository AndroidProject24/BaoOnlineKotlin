package com.toan_itc.core.imageload

import android.content.Context
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import com.facebook.imagepipeline.cache.MemoryCacheParams
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.listener.RequestLoggingListener
import okhttp3.OkHttpClient
import java.util.*

/**
 * Created by Toan.IT on 10/22/17.
 * Email: huynhvantoan.itc@gmail.com
 */

class ImagePipelineConfigFactory {
    private val IMAGE_PIPELINE_CACHE_DIR = "Fresco_Cache"

    private var sImagePipelineConfig: ImagePipelineConfig? = null
    private var sOkHttpImagePipelineConfig: ImagePipelineConfig? = null

    /**
     * Creates config using android http stack as network backend.
     */
    fun getImagePipelineConfig(context: Context): ImagePipelineConfig? {
        if (sImagePipelineConfig == null) {
            val configBuilder = ImagePipelineConfig.newBuilder(context)
            configureCaches(configBuilder, context)
            configureLoggingListeners(configBuilder)
            sImagePipelineConfig = configBuilder.build()
        }
        return sImagePipelineConfig
    }

    /**
     * Creates config using OkHttp as network backed.
     */
    fun getOkHttpImagePipelineConfig(context: Context): ImagePipelineConfig? {
        if (sOkHttpImagePipelineConfig == null) {
            val okHttpClient = OkHttpClient()
            val configBuilder = OkHttpImagePipelineConfigFactory.newBuilder(context, okHttpClient)
            configureCaches(configBuilder, context)
            configureLoggingListeners(configBuilder)
            sOkHttpImagePipelineConfig = configBuilder.build()
        }
        return sOkHttpImagePipelineConfig
    }

    /**
     * Configures disk and memory cache not to exceed common limits
     */
    private fun configureCaches(
            configBuilder: ImagePipelineConfig.Builder,
            context: Context) {
        val bitmapCacheParams = MemoryCacheParams(
                ConfigConstants.MAX_MEMORY_CACHE_SIZE, // Max total size of elements in the cache
                Integer.MAX_VALUE, // Max entries in the cache
                ConfigConstants.MAX_MEMORY_CACHE_SIZE, // Max total size of elements in eviction queue
                Integer.MAX_VALUE, // Max length of eviction queue
                Integer.MAX_VALUE)                    // Max cache entry size
        configBuilder
                .setBitmapMemoryCacheParamsSupplier { bitmapCacheParams }
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(context)
                                .setBaseDirectoryPath(context.applicationContext.cacheDir)
                                .setBaseDirectoryName(IMAGE_PIPELINE_CACHE_DIR)
                                .setMaxCacheSize(ConfigConstants.MAX_DISK_CACHE_SIZE.toLong())
                                .build())
    }

    private fun configureLoggingListeners(configBuilder: ImagePipelineConfig.Builder) {
        val requestListeners = HashSet<RequestListener>()
        requestListeners.add(RequestLoggingListener())
        configBuilder.setRequestListeners(requestListeners)
    }
}
