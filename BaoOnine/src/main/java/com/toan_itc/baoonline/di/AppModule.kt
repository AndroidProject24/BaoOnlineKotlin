package com.toan_itc.baoonline.di

import com.toan_itc.baoonline.api.ApiService
import com.toan_itc.baoonline.db.RepoDao
import com.toan_itc.baoonline.retrofit.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
internal class AppModule {
    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(ApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideRepoDao(): RepoDao {
        return RepoDao(provideRealm())
    }

    @Provides
    @Singleton
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

}
