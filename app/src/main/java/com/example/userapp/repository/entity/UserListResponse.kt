package com.example.userapp.repository.entity

data class UserListResponse(
    val result: List<ResultItem>? = null,
    val meta: Meta? = null
)
