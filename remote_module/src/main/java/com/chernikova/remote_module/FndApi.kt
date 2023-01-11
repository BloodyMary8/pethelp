package com.chernikova.remote_module

import com.chernikova.remote_module.entity.FndResults
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface FndApi {


    @GET("v2/animals/")
    fun getAnimal(
        @Header("bearer_key") bearerKey: String,
        //@Path("category") category: String,
        @Query("page") page: Int
    ): Observable<FndResults>

}