package com.example.userapp.repository.entity

data class Meta(
    val pageCount: Int? = null,
    val code: Int? = null,
    val perPage: Int? = null,
 //   val rateLimit: RateLim? = null,
    val success: Boolean? = null,
    val message: String? = null,
    val totalCount: Int? = null,
    val currentPage: Int? = null
)