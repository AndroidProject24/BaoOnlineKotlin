package com.toan_itc.baoonline.binding

import android.support.v4.app.Fragment
import android.view.View
import android.webkit.WebView
import com.facebook.drawee.view.SimpleDraweeView
import com.toan_itc.core.imageload.ImageLoaderListener
import com.toan_itc.core.richutils.dimenRes
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters
@Inject
internal constructor(internal val fragment: Fragment, private val imageLoaderListener: ImageLoaderListener?) {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: SimpleDraweeView, url: String) {
        imageLoaderListener?.loadController(url, imageView, fragment.dimenRes(R.dimen.image_song_width), fragment.dimenRes(R.dimen.image_song_height))
    }

    @BindingAdapter("imageUrlThumbnail")
    fun bindImageThumbnail(imageView: SimpleDraweeView, url: String) {
        imageLoaderListener?.loadController(url, imageView,fragment.dimenRes(R.dimen.image_song_height),fragment.dimenRes(R.dimen.image_song_height))
    }
}

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("html")
fun html(webView: WebView, html: String) {
    webView.loadDataWithBaseURL(null, html, "text/html", "utf8", null)
}