package com.toan_itc.baoonline.repository

import android.arch.lifecycle.LiveData
import com.toan_itc.baoonline.api.ApiResponse
import com.toan_itc.baoonline.api.ApiService
import com.toan_itc.baoonline.db.RepoDao
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.NetworkBoundResource
import com.toan_itc.baoonline.network.RateLimiter
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.utils.LiveRealmData
import io.realm.RealmResults
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
@Singleton
class RepoRepository
@Inject
constructor(val repoDao: RepoDao, val apiService: ApiService) {
    val repoListRateLimit = RateLimiter<String>(10, TimeUnit.MINUTES)
    fun loadRepos(owner: String): LiveData<Resource<RealmResults<Repo>>> {
        return object : NetworkBoundResource<Repo, List<Repo>>() {
            override fun saveCallResult(item: List<Repo>) {
                repoDao.insertRepos(item)
            }

            override fun shouldFetch(data :RealmResults<Repo>?): Boolean {
                return (data == null || data.isEmpty() || repoListRateLimit.shouldFetch(owner))
            }

            override fun loadFromDb(): LiveRealmData<Repo> {
                return repoDao.loadRepositories(owner)
            }

            override fun createCall(): LiveData<ApiResponse<List<Repo>>>  {
                return apiService.getRepos(owner)
            }

            override fun onFetchFailed() {
                repoListRateLimit.reset(owner)
            }
        }.asLiveData()
    }
}