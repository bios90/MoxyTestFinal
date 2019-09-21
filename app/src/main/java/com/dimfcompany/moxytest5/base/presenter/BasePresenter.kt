package com.dimfcompany.moxytest5.base.presenter

import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.dimfcompany.moxytest5.base.AppClass
import com.dimfcompany.moxytest5.di.presenter.PresenterComponent
import com.dimfcompany.moxytest5.di.presenter.PresenterModule
import com.dimfcompany.moxytest5.logic.utils.MessagesManager
import io.reactivex.disposables.CompositeDisposable
import java.lang.RuntimeException
import javax.inject.Inject

open class BasePresenter<T : MvpView> : MvpPresenter<T>()
{
    @Inject
    lateinit var messagesManager: MessagesManager

    protected var compositeDisposable: CompositeDisposable = CompositeDisposable()

    var injectorUsed = false
    protected lateinit var activity: MvpAppCompatActivity

    fun getPresenterComponent(activity: MvpAppCompatActivity): PresenterComponent
    {
        this.activity = activity
        return AppClass.getApplicationComponent().getPresenterComponent(PresenterModule(activity))
    }


}