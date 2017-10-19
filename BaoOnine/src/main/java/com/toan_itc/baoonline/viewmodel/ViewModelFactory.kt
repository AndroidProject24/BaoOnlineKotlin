package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v4.util.ArrayMap

/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

class ViewModelFactory
constructor(private val creators: ArrayMap<Class<out ViewModel>, ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: ViewModel? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            return creator as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}