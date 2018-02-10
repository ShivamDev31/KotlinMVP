package com.shivamdev.kotlinmvp.features.github.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shivamdev.kotlinmvp.R
import com.shivamdev.kotlinmvp.data.model.GithubRepo
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_github.view.*

/**
 * Created by shivam on 09/02/18.
 */
class GithubAdapter : RecyclerView.Adapter<GithubAdapter.GithubHolder>() {

    private val repos = mutableListOf<GithubRepo>()
    private val clickSubject = PublishSubject.create<GithubRepo>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GithubHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_github, parent,
                false)
        return GithubHolder(view)
    }

    override fun getItemCount() = repos.size

    override fun onBindViewHolder(holder: GithubHolder?, position: Int) {
        holder?.bind(repos[position])
    }

    fun updateRepos(repos: MutableList<GithubRepo>) {
        this.repos.clear()
        this.repos.addAll(repos)
        notifyDataSetChanged()
    }

    fun getClickListener(): PublishSubject<GithubRepo> = clickSubject

    inner class GithubHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                clickSubject.onNext(repos[adapterPosition])
            }
        }

        fun bind(githubRepo: GithubRepo) {
            itemView?.tvRepoName?.text = githubRepo.repoName
        }

    }
}