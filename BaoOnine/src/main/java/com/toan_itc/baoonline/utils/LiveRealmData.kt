package com.toan_itc.baoonline.utils

import io.reactivex.Flowable
import io.realm.RealmModel
import io.realm.RealmResults
import org.reactivestreams.Subscriber

/**
 * Created by ahmedrizwan on 9/18/17.
 * Realm as LiveData for observing changes
 */
class LiveRealmData<T : RealmModel>(private val results: RealmResults<T>) : Flowable<RealmResults<T>>() {
    override fun subscribeActual(s: Subscriber<in RealmResults<T>>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
/*
class LiveRealmData<T : RealmModel>(private val results: RealmResults<T>) : LiveData<RealmResults<T>>() {
    private val listener = RealmChangeListener<RealmResults<T>> {
        results -> value = results
    }

    override fun onActive() {
        results.addChangeListener(listener)
        value = results
    }

    override fun onInactive() {
        results.removeChangeListener(listener)
    }
}*/
