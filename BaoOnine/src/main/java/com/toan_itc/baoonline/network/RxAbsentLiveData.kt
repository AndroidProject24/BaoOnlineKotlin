package com.toan_itc.baoonline.network

import com.toan_itc.baoonline.data.HomeRepository
import com.toan_itc.baoonline.viewmodel.HomeLiveData

/**
 * Created by Toan.IT on 10/23/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

class RxAbsentLiveData private constructor(repository: HomeRepository, id_occasion: String, lang:String) : HomeLiveData(repository, id_occasion, lang) {
    init {
        postValue(null)
    }

    companion object {
        fun create(repository: HomeRepository): RxAbsentLiveData {
            return RxAbsentLiveData(repository, "","")
        }
    }
}
