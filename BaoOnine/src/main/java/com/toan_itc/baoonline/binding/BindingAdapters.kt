/*
package com.toan_itc.baoonline.binding

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.view.View
import android.webkit.WebView
import com.facebook.drawee.view.SimpleDraweeView
import com.toan_itc.core.imageload.ImageLoaderListener

object BindingAdapters {

    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @BindingAdapter("imageUrl")
    fun bindImage(imageLoaderListener: ImageLoaderListener, imageView: SimpleDraweeView, url: String) {
        if (!TextUtils.isEmpty(url)) {
            imageLoaderListener.loadController(imageView.context,url, imageView, imageView.width, imageView.height)
        }
    }

    @BindingAdapter("html")
    fun html(webView: WebView, html: String) {
        webView.loadDataWithBaseURL(null, html, "text/html", "utf8", null)
    }
}*/
