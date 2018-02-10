package com.shivamdev.kotlinmvp.features.github

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.shivamdev.kotlinmvp.R
import com.shivamdev.kotlinmvp.common.base.BaseActivity
import com.shivamdev.kotlinmvp.data.model.GithubRepo
import com.shivamdev.kotlinmvp.di.component.ActivityComponent
import com.shivamdev.kotlinmvp.exts.showToast
import com.shivamdev.kotlinmvp.features.github.adapter.GithubAdapter
import kotlinx.android.synthetic.main.activity_github.*
import java.util.*

/**
 * Created by shivam on 09/02/18.
 */
class GithubActivity : BaseActivity<GithubPresenter>(), GithubView {

    private lateinit var adapter: GithubAdapter

    override fun initView() {
        setupRecyclerView()
        val repos = intent.getParcelableArrayListExtra<GithubRepo>(REPOS_KEY)
        adapter.updateRepos(repos)
        setupRepoClick()
    }

    private fun setupRecyclerView() {
        adapter = GithubAdapter()
        rvRepos.layoutManager = LinearLayoutManager(this)
        rvRepos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rvRepos.adapter = adapter
    }

    private fun setupRepoClick() {
        adapter.getClickListener()
                .subscribe {
                    showToast("Clicked on : ${it.id} and Name : ${it.repoName}")
                }
    }

    override val layout: Int = R.layout.activity_github

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }

    companion object {
        private val REPOS_KEY = "repos"
        fun activityStarter(context: Context, githubRepos: List<GithubRepo>?) {
            val intent = Intent(context, GithubActivity::class.java)
            intent.putParcelableArrayListExtra(REPOS_KEY, githubRepos as ArrayList<out Parcelable>)
            context.startActivity(intent)
        }
    }

}