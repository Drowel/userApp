package com.example.userapp.repository

import com.example.userapp.repository.entity.UserListResponse
import com.example.userapp.repository.entity.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("public-api/users")
    fun getUserList(
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserListResponse>

    @GET("public-api/users/{userId}")   //  ----    here id our selected user
    fun getUser(
        @Path("userId") Id: Int?,
        @Query("_format") format: String,
        @Query("access-token") accessToken: String
    ): Call<UserResponse>

}