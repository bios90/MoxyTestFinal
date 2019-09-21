package com.dimfcompany.moxytest5.di.presenter

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.dimfcompany.moxytest5.base.rx.RxHelper
import com.dimfcompany.moxytest5.logic.utils.MessagesManager
import com.dimfcompany.moxytest5.networking.apis.ApiUsers
import dagger.Module
import dagger.Provides

@Module
class PresenterModule(private val activity: MvpAppCompatActivity)
{
    @Provides
    fun getActivity(): MvpAppCompatActivity
    {
        return activity
    }

    @Provides
    fun getContext(): Context
    {
        return activity
    }

    @Provides
    fun getLayoutInflater(context: Context): LayoutInflater
    {
        return LayoutInflater.from(context)
    }

    @Provides
    fun getMessagesManager(activity: MvpAppCompatActivity): MessagesManager
    {
        return MessagesManager(activity)
    }

    @Provides
    fun getRxHelper(messagesManager: MessagesManager, apiUsers: ApiUsers): RxHelper
    {
        return RxHelper(messagesManager, apiUsers)
    }
}