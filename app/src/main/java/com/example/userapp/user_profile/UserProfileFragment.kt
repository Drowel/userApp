package com.example.userapp.user_profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.userapp.R
import com.example.userapp.repository.entity.ResultItem
import com.example.userapp.repository.entity.UserResponse
import kotlinx.android.synthetic.main.fragment_user_profile.*
import kotlinx.android.synthetic.main.fragment_user_profile.view.*


class UserProfileFragment: Fragment() {

    companion object {

        const val ID_KEY = "ID_KEY"

        fun newInstance(id: Int): UserProfileFragment{
            val fragment = UserProfileFragment()
            val bundle = Bundle()
            bundle.putInt(ID_KEY, id)
            fragment.arguments = bundle

            return fragment
        }
    }

    lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ID_KEY)


        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        viewModel.userProfileLiveData.observe(viewLifecycleOwner, userProfileObserver)
        viewModel.getUser(id)

    }

    fun showProfile(data: ResultItem?){
        if (data !=null ) {
            item_id.text = data.id.toString()
            first_name.text = data.first_name.toString()
            last_name.text = data.last_name.toString()
            website.text = data.website.toString()
            address.text = data.address.toString()
            gender.text = data.gender.toString()
            phone.text = data.phone.toString()
            dob.text = data.dob.toString()
            email.text = data.email.toString()
            status.text = data.status.toString()
        }

    }

    private val userProfileObserver = Observer<UserResponse> {
        it?.result?.let {
            result -> showProfile(result)
        }
    }


}