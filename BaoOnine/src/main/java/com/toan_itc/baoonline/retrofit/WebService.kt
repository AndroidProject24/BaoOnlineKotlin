package com.toan_itc.baoonline.retrofit

import com.toan_itc.baoonline.model.Repo
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ahmedrizwan on 9/9/17.
 * Retrofit Service class
 * TODO: Add your Web Api Endpoints here!
 */
interface WebService {

    @GET("users/{login}/repos")
    fun getRepos(@Path("login") login: String): Flowable<List<Repo>>

}