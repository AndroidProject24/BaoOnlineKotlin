package com.toan_itc.baoonline.network

import com.toan_itc.baoonline.repository.RepoRepository
import com.toan_itc.baoonline.viewmodel.RepoLiveData

/**
 * Created by ahmedrizwan on 9/9/17.
 * Helper class for transmitting an empty LiveData - Pretty useful!
 */
class AbsentLiveData
private constructor(repository: RepoRepository, string: String) : RepoLiveData(repository, string) {
    init {
        postValue(null)
    }

    companion object {
        fun create(repository: RepoRepository): AbsentLiveData {
            return AbsentLiveData(repository, "")
        }
    }
}
