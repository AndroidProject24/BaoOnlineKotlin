package com.toan_itc.baoonline.db

import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.utils.LiveRealmData
import com.toan_itc.baoonline.utils.asLiveData
import io.realm.Case
import io.realm.Realm
import io.realm.Sort

/**
 * Created by ahmedrizwan on 9/9/17.
 * Realm Dao for Repo
 * TODO: Change the dao based on what you want
 */
class RepoDao(val realm: Realm) {
    fun insertRepos(items: List<Repo>){
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(items)
        realm.commitTransaction()
    }

    fun loadRepositories(owner: String): LiveRealmData<Repo> {
        return realm.where(Repo::class.java)
                .equalTo("owner.login", owner, Case.INSENSITIVE)
                .findAllSorted("stars", Sort.DESCENDING)
                .asLiveData()
    }
}