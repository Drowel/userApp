package com.example.userapp.user_profile

import androidx.lifecycle.ViewModel
import com.example.userapp.repository.entity.UserResponse
import com.teachmeskills.myapplication.repository.RemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData

class UserProfileViewModel : ViewModel() {


    private val repository = RemoteRepository.getInstance()

    val userProfileLiveData = MutableLiveData<UserResponse>()

    fun getUser(id: Int?) {
        repository.getUser(id)
            .enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    userProfileLiveData.postValue(response.body())
                }
            })
    }


}