package com.example.userapp.repository

import com.example.userapp.repository.entity.UserListResponse
import com.example.userapp.repository.entity.UserResponse
import retrofit2.Call

interface Repository {
    fun getUserList(): Call<UserListResponse>
    fun getUser(id: Int?): Call<UserResponse>
}