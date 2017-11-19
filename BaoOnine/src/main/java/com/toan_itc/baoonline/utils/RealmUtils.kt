@file:JvmName("RealmUtils")

// pretty name for utils class if called from
package com.toan_itc.baoonline.utils

import com.toan_itc.baoonline.ui.common.LiveRealmData
import io.realm.RealmModel
import io.realm.RealmResults

/**
 * Created by Toan.IT on 10/19/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

fun <T : RealmModel> RealmResults<T>.asLiveData() = LiveRealmData(this)

