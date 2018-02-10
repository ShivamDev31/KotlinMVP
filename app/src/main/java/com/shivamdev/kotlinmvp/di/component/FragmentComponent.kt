package com.shivamdev.kotlinmvp.di.component

import com.shivamdev.kotlinmvp.di.module.FragmentModule
import com.shivamdev.kotlinmvp.di.scope.PerFragment
import dagger.Component

/**
 * Created by shivam on 02/02/18.
 */

@PerFragment
@Component(dependencies = [(AppComponent::class)],
        modules = [FragmentModule::class])
interface FragmentComponent {

}