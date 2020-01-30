package com.example.userapp.user_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userapp.repository.entity.UserListResponse
import com.teachmeskills.myapplication.repository.RemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserListViewModel: ViewModel() {


    private val repository = RemoteRepository.getInstance()

    val userListLiveData = MutableLiveData<UserListResponse>()



    fun getUserList() {
        repository.getUserList()
            .enqueue(object : Callback<UserListResponse> {
                override fun onFailure(call: Call<UserListResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UserListResponse>,
                    response: Response<UserListResponse>
                ) {
                    userListLiveData.postValue(response.body())

                }
            })


    }


}