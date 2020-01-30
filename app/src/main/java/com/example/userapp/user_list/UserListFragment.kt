package com.example.userapp.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapp.MainActivity
import com.example.userapp.R
import com.example.userapp.repository.entity.ResultItem
import com.example.userapp.repository.entity.UserListResponse
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment: Fragment(), DataAdapter.DataCallback {

    companion object{
        fun newInstance() = UserListFragment()
    }

    lateinit var mViewModel: UserListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        mViewModel.getUserList()
        mViewModel.userListLiveData.observe(viewLifecycleOwner, userListObserver)
    }

    override fun itemClicked(item: ResultItem) {
        (activity as MainActivity).showProfile(item.id!!)
    }

    fun showData(list: List<ResultItem>?){
        // show in RacyclerView !!

        if(list != null){
            val adapter = DataAdapter(this)
            adapter.list = list
            recycler_view.adapter = adapter
            recycler_view.layoutManager =
                LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        }

    }
    private val userListObserver = Observer<UserListResponse> {
        result -> showData(result.result)
    }
}