package com.shivamdev.kotlinmvp.common

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.shivamdev.kotlinmvp.di.component.AppComponent
import com.shivamdev.kotlinmvp.di.component.DaggerAppComponent
import com.shivamdev.kotlinmvp.di.module.AppModule
import timber.log.Timber

/**
 * Created by shivam on 01/02/18.
 */
open class MvpApp : Application() {

    lateinit var component: AppComponent
        private set

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = setupDagger()
        Timber.plant(Timber.DebugTree())
    }

    open fun setupDagger(): AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

    companion object {
        lateinit var instance: MvpApp
            private set
    }

}