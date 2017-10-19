package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.AbsentLiveData
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.repository.RepoRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
class RepoViewModel
@Inject constructor(private val repository: RepoRepository):ViewModel() {

    var currentRepoUser: String? = null
    val results: LiveData<Resource<List<Repo>>>

    private val query: MutableLiveData<String> = MutableLiveData()

    init {
        results = Transformations.switchMap(query, {
            when {
                it == null || it.length == 1 -> AbsentLiveData.create(repository)
                else -> RepoLiveData(repository, it)
            }
        })
    }

    fun setQuery(originalInput: String?, force:Boolean) {
        if(originalInput==null) return
        val input = originalInput.toLowerCase(Locale.getDefault()).trim { it <= ' ' }
        if (input == query.value && !force) {
            return
        }
        query.value = input
    }

}