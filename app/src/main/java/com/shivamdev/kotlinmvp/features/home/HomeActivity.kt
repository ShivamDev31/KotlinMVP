package com.shivamdev.kotlinmvp.features.home

import com.shivamdev.kotlinmvp.R
import com.shivamdev.kotlinmvp.common.base.BaseActivity
import com.shivamdev.kotlinmvp.data.model.GithubRepo
import com.shivamdev.kotlinmvp.di.component.ActivityComponent
import com.shivamdev.kotlinmvp.exts.*
import com.shivamdev.kotlinmvp.features.github.GithubActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.progress_layout.*

class HomeActivity : BaseActivity<HomePresenter>(), HomeView {

    override fun initView() {
        bSubmit.setOnClickListener {
            val userId = etGithubId.toText()
            hideKeyboard()
            presenter.getUserRepos(userId)
        }
    }

    override fun showEmptyIdError() {
        showToast(R.string.error_empty_user_id)
    }

    override fun showLoader() {
        progressBar.show()
        bSubmit.isEnabled = false
    }

    override fun hideLoader() {
        progressBar.hide()
        bSubmit.isEnabled = true
    }

    override fun showUserRepos(repos: List<GithubRepo>?) {
        GithubActivity.activityStarter(this, repos)
    }

    override val layout: Int = R.layout.activity_home

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }


}
