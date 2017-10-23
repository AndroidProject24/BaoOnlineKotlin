package com.toan_itc.baoonline;

import android.app.Activity;
import android.app.Application;

import com.toan_itc.baoonline.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;

/**
 * Created by Toan.IT on 10/22/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

public class BaseApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //AppInjector.init(this);
        DaggerAppComponent.builder().application(this)
                .build().inject(this);
        Realm.init(this);
        //Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
        if (BuildConfig.DEBUG) {
            //Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
