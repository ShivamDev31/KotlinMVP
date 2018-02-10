package com.shivamdev.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.shivamdev.kotlinmvp.common.constants.PREF_FILE_NAME
import com.shivamdev.kotlinmvp.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by shivam on 01/02/18.
 */

@Module(includes = [ApiModule::class])
class AppModule(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

}