package com.toan_itc.baoonline.retrofit

import android.arch.lifecycle.LiveData
import com.toan_itc.baoonline.api.ApiResponse
import com.toan_itc.baoonline.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ahmedrizwan on 9/9/17.
 * Retrofit Service class
 * TODO: Add your Web Api Endpoints here!
 */
interface WebService {

    @GET("users/{login}/repos")
    fun getRepos(@Path("login") login: String): LiveData<ApiResponse<List<Repo>>>

}