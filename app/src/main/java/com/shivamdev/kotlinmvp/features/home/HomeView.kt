package com.shivamdev.kotlinmvp.features.home

import com.shivamdev.kotlinmvp.common.mvp.BaseView
import com.shivamdev.kotlinmvp.data.model.GithubRepo

/**
 * Created by shivam on 09/02/18.
 */
interface HomeView : BaseView {
    fun showEmptyIdError()
    fun showLoader()
    fun hideLoader()
    fun showUserRepos(repos: List<GithubRepo>?)
}