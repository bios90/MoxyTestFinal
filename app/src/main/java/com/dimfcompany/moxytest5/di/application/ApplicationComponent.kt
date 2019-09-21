package com.dimfcompany.moxytest5.di.application

import com.dimfcompany.moxytest5.di.presenter.PresenterComponent
import com.dimfcompany.moxytest5.di.presenter.PresenterModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent
{
    fun getPresenterComponent(module: PresenterModule): PresenterComponent
}