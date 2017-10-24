@file:JvmName("RichUtils")
@file:JvmMultifileClass

package com.toan_itc.core.utils

import android.text.TextUtils

fun String.isEmptyOrReturn() = if (TextUtils.isEmpty(this)) "" else this

fun String.isEmpty() = TextUtils.isEmpty(this)