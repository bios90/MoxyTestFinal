package com.dimfcompany.moxytest5.base.rx

import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ToggleButton
import com.dimfcompany.moxytest5.logic.models.Model_User
import com.dimfcompany.moxytest5.logic.utils.MessagesManager
import com.dimfcompany.moxytest5.networking.apis.ApiUsers
import com.dimfcompany.moxytest5.networking.helpers.GlobalNetworkHelper
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RxHelper(private val messagesManager: MessagesManager,private val apiUsers: ApiUsers)
{
    companion object
    {
        fun <T> baseObservable(messagesManager: MessagesManager): ObservableTransformer<T, T>
        {
            return ObservableTransformer(
                {
                    it.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .filter(
                                {
                                    if (!GlobalNetworkHelper.isNetworkAvailable())
                                    {
                                        messagesManager.showNoInternetAlerter()
                                        return@filter false
                                    }

                                    return@filter true
                                }).doOnSubscribe(
                                {
                                    messagesManager.showProgressDialog()
                                })
                            .doFinally(
                                {
                                    messagesManager.dismissProgressDialog()
                                })
                })
        }
    }

    fun get_all_users():Observable<List<Model_User>>
    {
        return apiUsers.get_all_users(null)
                .compose(baseObservable(messagesManager))
    }

}