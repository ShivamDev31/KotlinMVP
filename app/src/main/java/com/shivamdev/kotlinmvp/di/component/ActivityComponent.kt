package com.shivamdev.kotlinmvp.di.component

import com.shivamdev.kotlinmvp.di.module.ActivityModule
import com.shivamdev.kotlinmvp.di.scope.PerActivity
import com.shivamdev.kotlinmvp.features.github.GithubActivity
import com.shivamdev.kotlinmvp.features.home.HomeActivity
import dagger.Component

/**
 * Created by shivam on 01/02/18.
 */

@PerActivity
@Component(dependencies = [(AppComponent::class)],
        modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(githubActivity: GithubActivity)

}