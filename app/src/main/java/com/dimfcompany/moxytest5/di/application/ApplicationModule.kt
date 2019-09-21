package com.dimfcompany.moxytest5.di.application

import com.dimfcompany.moxytest5.base.AppClass
import com.dimfcompany.moxytest5.base.Constants
import com.dimfcompany.moxytest5.networking.apis.ApiUsers
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule
{
    @Singleton
    @Provides
    fun getRetrofit(): Retrofit
    {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(AppClass.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
    }

    @Singleton
    @Provides
    fun getApiUsers(retrofit: Retrofit): ApiUsers
    {
        return retrofit.create(ApiUsers::class.java)
    }
}