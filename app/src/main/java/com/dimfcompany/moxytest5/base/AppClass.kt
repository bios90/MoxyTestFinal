package com.dimfcompany.moxytest5.base

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.dimfcompany.moxytest5.di.application.ApplicationComponent
import com.dimfcompany.moxytest5.di.application.DaggerApplicationComponent
import com.dimfcompany.moxytest5.networking.helpers.GlobalNetworkHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class AppClass : Application()
{
    val TAG: String = "AppClass"

    companion object
    {
        private lateinit var appClass: AppClass
        private lateinit var gson: Gson
        private lateinit var applicationComponent: ApplicationComponent

        fun getApp(): AppClass
        {
            return appClass
        }

        fun getGson(): Gson
        {
            return gson
        }

        fun getApplicationComponent(): ApplicationComponent
        {
            return applicationComponent
        }
    }

    override fun onCreate()
    {
        super.onCreate()
        appClass = this

        gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()

        applicationComponent = DaggerApplicationComponent.create()

        GlobalNetworkHelper.testZip().subscribe(
            {
                Log.e(TAG, "Result is : $it")
            },
            {
                it.printStackTrace()
            },
            {
                Log.e(TAG, "On complete: " )
            })
    }
}