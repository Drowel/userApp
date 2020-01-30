package com.example.userapp.repository.entity

import com.google.gson.annotations.SerializedName

data class ResultItem(
    val website: String? = null,
    val address: String? = null,
    val gender: String? = null,
    val phone: String? = null,
    val dob: String? = null,
    val id: Int? = null,
//     @SerializedName("first_name")   // если хотим задать своё имя а не как в джсоне
    val first_name: String? = null,
    val last_name: String? = null,
    val email: String? = null,
    val status: String? = null
)