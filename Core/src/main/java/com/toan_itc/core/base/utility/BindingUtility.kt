package com.toan_itc.core.base.utility

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView


object BindingUtility {


    @BindingAdapter("onClick")
    fun setOnClick(view: View, listener: View.OnClickListener) {
        view.setOnClickListener(listener)
    }


    @BindingAdapter("onLongClick")
    fun setOnLongClick(view: View, listener: View.OnLongClickListener) {
        view.setOnLongClickListener(listener)
    }


    @BindingAdapter("visible")
    fun setVisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }


    @BindingAdapter("invisible")
    fun setInvisible(view: View, invisible: Boolean) {
        view.visibility = if (invisible) View.INVISIBLE else View.VISIBLE
    }


    @BindingAdapter("gone")
    fun setGone(view: View, gone: Boolean) {
        view.visibility = if (gone) View.GONE else View.VISIBLE
    }


    @BindingAdapter("imageBitmap")
    fun setImageBitmap(imageView: ImageView, bitmap: Bitmap) {
        imageView.setImageBitmap(bitmap)
    }

/*
    @BindingConversion
    fun convertBooleanToVisibility(visible: Boolean): Int {
        return if (visible) View.VISIBLE else View.GONE
    }*/
}
