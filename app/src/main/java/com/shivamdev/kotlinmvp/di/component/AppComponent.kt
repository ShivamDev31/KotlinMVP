package com.shivamdev.kotlinmvp.di.component


import com.shivamdev.kotlinmvp.data.remote.GithubApi
import com.shivamdev.kotlinmvp.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by shivam on 01/02/18.
 */

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun githubApi(): GithubApi

}
