package com.shivamdev.kotlinmvp.dummy

import com.shivamdev.kotlinmvp.data.model.GithubRepo

/**
 * Created by shivam on 10/02/18.
 */

const val USER_ID = "shivamdev31"

fun getUserRepos(): List<GithubRepo> {
    val userRepos = mutableListOf<GithubRepo>()

    (0..5).mapTo(userRepos) {
        GithubRepo(it, "Repo $it")
    }
    return userRepos
}