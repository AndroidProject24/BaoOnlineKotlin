package com.toan_itc.baoonline.repository

import android.support.annotation.Nullable
import com.toan_itc.baoonline.db.RepoDao
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.AppThreadExecutors
import com.toan_itc.baoonline.network.NetworkBoundResource
import com.toan_itc.baoonline.network.RateLimiter
import com.toan_itc.baoonline.network.Resource
import com.toan_itc.baoonline.retrofit.WebService
import io.reactivex.Flowable
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
constructor(val repoDao: RepoDao, val webService: WebService, val appThreadExecutors: AppThreadExecutors) {
    val repoListRateLimit = RateLimiter<String>(10, TimeUnit.MINUTES)

    fun loadRepos(owner: String): Flowable<Resource<List<Repo>>> {
        return object : NetworkBoundResource<List<Repo>, List<Repo>>(appThreadExecutors) {
            override fun saveCallResult(item: List<Repo>) {
                repoDao.insertRepos(item)
            }

            override fun shouldFetch(@Nullable data: List<Repo>?): Boolean {
                return (data == null || data.isEmpty()
                        || repoListRateLimit.shouldFetch(owner))
            }

            override fun loadFromDb(): Flowable<List<Repo>> {
                //return repoDao.loadRepositories(owner)
                return webService.getRepos(owner)
            }

            override fun createCall(): Flowable<List<Repo>> {
                return webService.getRepos(owner)
            }

            override fun onFetchFailed() {
                repoListRateLimit.reset(owner)
            }
        }.asFlowable()
    }

}