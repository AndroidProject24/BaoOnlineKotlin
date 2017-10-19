package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.LiveData
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.repository.RepoRepository
import io.reactivex.disposables.Disposable
/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
open class RepoLiveData(repoRepository: RepoRepository, owner:String):
        LiveData<Resource<List<Repo>>>() {
    private var disposable: Disposable? = null

    init {
        disposable = repoRepository.loadRepos(owner).subscribe({
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