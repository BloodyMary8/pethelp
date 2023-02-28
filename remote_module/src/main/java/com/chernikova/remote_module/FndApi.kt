package com.chernikova.remote_module

interface FndApi {

 @POST("v2/oauth2/token")
 fun getToken(
     @Query("grant_type") grantType: String = "client_credentials",
     @Query("client_id") clientId: String,
     @Query("client_secret") clientSecret: String,
 ): Single<Token>

