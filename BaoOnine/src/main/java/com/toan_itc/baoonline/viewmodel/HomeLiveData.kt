package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.LiveData
import com.toan_itc.baoonline.data.HomeRepository
import com.toan_itc.baoonline.data.model.Home
import com.toan_itc.baoonline.network.Resource
import io.reactivex.disposables.Disposable

/**
 * Created by Toan.IT on 11/6/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
open class HomeLiveData(homeRepository: HomeRepository, id_occasion: String, lang: String):
        LiveData<Resource<Home>>() {
    private var disposable: Disposable? = null

    init {
        disposable = homeRepository.loadHome(id_occasion,lang).subscribe({
            data ->
            value = data
        })
    }

    override fun onInactive() {
        super.onInactive()
        if(disposable?.isDisposed?.not() == true){
            disposable?.dispose()
        }
    }
}