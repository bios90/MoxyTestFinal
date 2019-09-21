package com.dimfcompany.moxytest5.ui.act_first

import android.content.Context
import android.widget.Toast
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimfcompany.moxytest5.base.presenter.BasePresenter
import com.dimfcompany.moxytest5.base.rx.RxHelper
import javax.inject.Inject

@InjectViewState
class ActFirstPresenter : BasePresenter<ActFirstMvp>()
{
    lateinit var context: Context

    @Inject
    lateinit var rxHelper: RxHelper

    init
    {

    }

    fun show_green_alerter()
    {
        messagesManager.showGreenAlerter("One two three four five six")
    }

    fun clicked_register()
    {
        compositeDisposable.add(rxHelper.get_all_users()
                .subscribe(
                    {
                        viewState.bind_dummy_data(it.get(0).last_name!!, it.get(1).last_name!!)
                    },
                    {
                        it.printStackTrace()
                    }))
    }
}