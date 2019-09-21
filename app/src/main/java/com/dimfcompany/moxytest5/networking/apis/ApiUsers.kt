package com.dimfcompany.moxytest5.networking.apis

import com.dimfcompany.moxytest5.base.Constants
import com.dimfcompany.moxytest5.logic.models.Model_User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUsers
{
    @GET(Constants.URL_GET_ALL_USERS)
    fun get_all_users(@Query("search") search: String?): Observable<List<Model_User>>
}