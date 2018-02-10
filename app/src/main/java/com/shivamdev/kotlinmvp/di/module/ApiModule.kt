package com.shivamdev.kotlinmvp.di.module

import com.shivamdev.kotlinmvp.data.remote.GithubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by shivam on 20/7/17.
 */

@Module(includes = [(NetworkModule::class)])
class ApiModule {

    @Provides
    @Singleton
    internal fun provideInstaApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }

}