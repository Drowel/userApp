package com.example.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userapp.repository.entity.ResultItem
import com.example.userapp.user_list.DataAdapter
import com.example.userapp.user_list.UserListFragment
import com.example.userapp.user_profile.UserProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserListFragment.newInstance())
            .commit()

    }

    fun showProfile(id: Int){

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserProfileFragment.newInstance(id))
            .addToBackStack("")
            .commit()
    }

}
