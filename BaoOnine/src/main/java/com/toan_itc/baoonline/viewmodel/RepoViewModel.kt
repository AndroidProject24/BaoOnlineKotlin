package com.toan_itc.baoonline.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.AbsentLiveData
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.repository.RepoRepository
import io.realm.RealmResults
import java.util.*
import javax.inject.Inject

/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
class RepoViewModel
@Inject
constructor(repository: RepoRepository) : ViewModel() {
    @VisibleForTesting
    internal val repoId: MutableLiveData<RepoId>
    val repo: LiveData<Resource<RealmResults<Repo>>>
    var currentRepoUser: String? = null
    private val query: MutableLiveData<String> = MutableLiveData()
    init {
        this.repoId = MutableLiveData()
        repo = Transformations.switchMap(query, {
            when {
                it == null || it.length == 1 -> AbsentLiveData.create()
                else -> repository.loadRepos(it)
            }
        })
    }

    fun retry() {
        val current = repoId.value
        if (current != null && !current.isEmpty) {
            repoId.setValue(current)
        }
    }

    fun setQuery(originalInput: String?, force:Boolean) {
        if(originalInput==null) return
        val input = originalInput.toLowerCase(Locale.getDefault()).trim { it <= ' ' }
        if (input == query.value && !force) {
            return
        }
        query.value = input
    }
    @VisibleForTesting
    fun setId(owner: String, name: String) {
        val update = RepoId(owner, name)
        if (Objects.equals(repoId.value, update)) {
            return
        }
        repoId.setValue(update)
    }

    @VisibleForTesting
    internal class RepoId(owner: String?, name: String?) {
        val owner: String?
        val name: String?

        val isEmpty: Boolean
            get() = owner == null || name == null || owner.length == 0 || name.length == 0

        init {
            this.owner = owner?.trim { it <= ' ' }
            this.name = name?.trim { it <= ' ' }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || javaClass != other.javaClass) {
                return false
            }

            val repoId = other as RepoId?

            if (if (owner != null) owner != repoId!!.owner else repoId!!.owner != null) {
                return false
            }
            return if (name != null) name == repoId.name else repoId.name == null
        }

        override fun hashCode(): Int {
            var result = owner?.hashCode() ?: 0
            result = 31 * result + (name?.hashCode() ?: 0)
            return result
        }
    }
}
