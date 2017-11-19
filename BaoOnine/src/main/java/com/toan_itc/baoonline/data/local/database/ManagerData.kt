package com.toan_itc.baoonline.data.local.database

import com.toan_itc.baoonline.data.model.Home
import com.toan_itc.baoonline.data.model.SongNew
import io.reactivex.Flowable
import io.realm.Realm

/**
 * Created by Toan.IT on 11/3/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

interface RepositoryData {
    fun getRealmBox(): Realm

    fun getRealmDB(): Realm

    fun insertDataSongNew(songNew: SongNew)

    fun insertDataHome(home: Home)

    fun getDataHome() : Flowable<Home>
}