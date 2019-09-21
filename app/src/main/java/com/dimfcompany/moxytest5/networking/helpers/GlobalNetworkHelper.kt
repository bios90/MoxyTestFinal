package com.dimfcompany.moxytest5.networking.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.dimfcompany.moxytest5.base.AppClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.Okio
import java.io.File
import java.util.concurrent.TimeUnit

class GlobalNetworkHelper() {
    companion object {
        fun isNetworkAvailable(): Boolean {
            val connectivityManager =
                AppClass.getApp().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        fun fileToPartBody(file: File?, field_name: String): MultipartBody.Part? {
            var bodyFile: MultipartBody.Part? = null

            if (file != null && file.exists()) {
                val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
                bodyFile = MultipartBody.Part.createFormData(field_name, file.getName(), requestBody)
            }

            return bodyFile
        }

        fun modelToBody(any: Any, field_name: String): MultipartBody.Part {
            val str = AppClass.getGson().toJson(any)
            return MultipartBody.Part.createFormData(field_name, str)
        }

        fun getModelFromString(str: String, model: Class<out Any>): Any {
            return AppClass.getGson().fromJson(str, model)
        }

        fun testStrings(): Observable<String> {
//            return Observable.just("One", "Two", "Three")
//
            return Observable.just("dsg")
                .flatMap(
                    {
                        Observable.just("one", "two", "three", "four")
                    })
                .concatMap(
                    {
                        Observable.just(it).delay(500, TimeUnit.MILLISECONDS)
                    })
                .flatMap(
                    {
                        Log.e("dfgdf", "HERER: " );
                        Observable.just(it.reversed())
                    })


        }

        fun testInts(): Observable<Int> {
            return Observable.just(1, 2, 3, 4, 5, 6, 7)

//            return Observable.empty<Any>()
////                    .delay(5000, TimeUnit.MILLISECONDS)
//                    .flatMap(
//                        {
//                            Observable.just(1, 2, 3, 4, 5, 6, 7)
//                        })
        }

        fun testZip(): Observable<String> {
            return Observable.zip(
                testStrings(),
                testInts(), BiFunction(
                    { str, num ->
                        "$str $num"
                    })
            )
        }
    }
}