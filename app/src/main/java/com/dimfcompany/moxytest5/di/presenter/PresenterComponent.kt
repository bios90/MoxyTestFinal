package com.dimfcompany.moxytest5.di.presenter

import com.dimfcompany.moxytest5.ui.act_first.ActFirstPresenter
import dagger.Subcomponent

@Subcomponent(modules = [PresenterModule::class])
interface PresenterComponent
{
    fun inject(presenter: ActFirstPresenter)
}