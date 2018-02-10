package com.shivamdev.kotlinmvp.features.home

import com.shivamdev.kotlinmvp.common.mvp.BasePresenter
import com.shivamdev.kotlinmvp.data.remote.GithubApi
import com.shivamdev.kotlinmvp.exts.transformSingle
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by shivam on 09/02/18.
 */
class HomePresenter @Inject constructor(private val githubApi: GithubApi) : BasePresenter<HomeView>() {
    fun getUserRepos(userId: String) {

        if (userId.isBlank()) {
            view?.showEmptyIdError()
            return
        }

        getUserReposFromGithub(userId)
    }

    private fun getUserReposFromGithub(userId: String) {
        view?.showLoader()
        compositeDisposable += githubApi.getGithubUserRepos(userId)
                ?.compose(transformSingle())
                ?.subscribe({ repos ->
                    Timber.i(repos.toString())
                    view?.showUserRepos(repos)
                    view?.hideLoader()
                }, {
                    Timber.e(it)
                    view?.hideLoader()
                })!!
    }

}