package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.toan_itc.baoonline.data.HomeRepository
import com.toan_itc.baoonline.data.model.Home
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.network.RxAbsentLiveData
import com.toan_itc.baoonline.ui.common.switchMap
import java.util.*
import javax.inject.Inject


class HomeViewModel
@Inject
internal constructor(repository: HomeRepository) : ViewModel() {
   // private var repository: HomeRepository
    private val query: MutableLiveData<String> = MutableLiveData()
    val results: LiveData<Resource<Home>>

    init {
        results = query.switchMap {
            if (it.isEmpty()) RxAbsentLiveData.create(repository)
            else HomeLiveData(repository, it,"vi")
        }
    }

    fun retry() {
        val current = query.value
        if (current != null && !current.isEmpty()) {
            query.value = current
        }
    }

    fun setQuery(originalInput: String?, force: Boolean) {
        if (originalInput == null) return
        val input = originalInput.toLowerCase(Locale.getDefault()).trim { it <= ' ' }
        if (input == query.value && !force) {
            return
        }
        query.value = input
    }

    fun onItemClick() {
       // mListener.onItemClick(mBlog.getBlogUrl())
    }

}
