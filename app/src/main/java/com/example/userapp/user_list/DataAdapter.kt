package com.example.userapp.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userapp.MainActivity
import com.example.userapp.R
import com.example.userapp.repository.entity.ResultItem
import kotlinx.android.synthetic.main.fragment_user_profile.view.*
import kotlinx.android.synthetic.main.item_data.*
import kotlinx.android.synthetic.main.item_data.view.*
import kotlinx.android.synthetic.main.item_data.view.first_name
import kotlinx.android.synthetic.main.item_data.view.item_id
import kotlinx.android.synthetic.main.item_data.view.last_name

class DataAdapter(private val callback: DataCallback?) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    var list = emptyList<ResultItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            callback?.itemClicked(list[holder.adapterPosition])     ///    Item Click !!!!  here
        }
    }

    override fun getItemCount() = list.size


    class DataViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val textId = itemView.item_id
        private val firstName = itemView.first_name
        private val lastName = itemView.last_name

        fun bind(data: ResultItem) {
            textId.text = data.id.toString()
            firstName.text = data.first_name.toString()
            lastName.text = data.last_name.toString()
            }

    }


    interface DataCallback {
       fun itemClicked(item: ResultItem)
    }


}


