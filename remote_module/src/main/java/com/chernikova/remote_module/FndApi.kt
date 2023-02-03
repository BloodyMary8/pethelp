package com.chernikova.remote_module

import com.chernikova.remote_module.entity.FndResults
import com.chernikova.remote_module.json.Token
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface FndApi {

 @POST("v2/oauth2/token")
 fun getToken(
     @Header("grant_type") grantType: String = "client_credentials",
     @Header("client_id") clientId: String,
     @Header("client_secret") clientSecret: String,
 ): Single<Token>

 @GET("v2/animals")
    fun getAnimal(
        @Header("Authorization") token: String?,
        @Query("type") type: String,
    ): Observable<FndResults>
}
