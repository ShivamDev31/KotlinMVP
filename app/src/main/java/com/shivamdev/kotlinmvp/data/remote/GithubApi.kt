package com.shivamdev.kotlinmvp.data.remote

import com.shivamdev.kotlinmvp.data.model.GithubRepo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by shivam on 09/02/18.
 */
interface GithubApi {

    @GET("/users/{user_id}/repos")
    fun getGithubUserRepos(@Path("user_id") userId: String): Single<List<GithubRepo>>?

}