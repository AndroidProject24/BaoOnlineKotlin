package com.toan_itc.core.imageload

import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.ControllerListener
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ImageDecodeOptions
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
class FrescoImageLoader : ImageLoaderListener {

    override fun loadImage(url: String, simpleDraweeView: SimpleDraweeView?) {
        simpleDraweeView?.setImageURI(url)
    }

    override fun loadController(url: String, simpleDraweeView: SimpleDraweeView?, width: Int, height: Int, controllerListener: ControllerListener<Any>?) {
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setLocalThumbnailPreviewsEnabled(true)
                .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                .setProgressiveRenderingEnabled(true)
                .setImageDecodeOptions(ImageDecodeOptions.defaults())
                .setResizeOptions(ResizeOptions(dip2px(width), dip2px(height)))
                .build()
        val controller = Fresco.newDraweeControllerBuilder()
                .setTapToRetryEnabled(true)
                .setAutoPlayAnimations(true)
                .setOldController(simpleDraweeView?.controller)
                .setImageRequest(request)
                .setControllerListener(controllerListener)
                .build()
        simpleDraweeView?.controller = controller
    }

    override fun loadController(url: String, simpleDraweeView: SimpleDraweeView?, width: Int, height: Int) {
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setLocalThumbnailPreviewsEnabled(true)
                .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                .setProgressiveRenderingEnabled(true)
                .setImageDecodeOptions(ImageDecodeOptions.defaults())
                .setResizeOptions(ResizeOptions(dip2px(width), dip2px(height)))
                .build()
        val controller = Fresco.newDraweeControllerBuilder()
                .setTapToRetryEnabled(true)
                .setAutoPlayAnimations(true)
                .setOldController(simpleDraweeView?.controller)
                .setImageRequest(request)
                .build()
        simpleDraweeView?.controller = controller
    }

    override fun loadHierarchy(url: String, simpleDraweeView: SimpleDraweeView?) {
        val hierarchy = GenericDraweeHierarchyBuilder(null)
                .setFadeDuration(300)
                .setPlaceholderImage(null)
                .setBackground(null)
                .setOverlays(null)
                .build()
        simpleDraweeView?.hierarchy = hierarchy
    }

    fun dip2px(value: Int): Int = 50
}
