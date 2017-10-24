@file:JvmName("RichUtils")
@file:JvmMultifileClass

package com.toan_itc.core.utils

import android.app.Activity
import android.app.Dialog

/**
 * hide keyboard
 */
fun Activity.hideKeyboard() {
    this.currentFocus?.let {
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

/**
 * hide keyboard
 */
fun Dialog.hideKeyboard() {
    this.currentFocus?.let {
        this.context.inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}