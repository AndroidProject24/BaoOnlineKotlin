package com.toan_itc.baoonline.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.toan_itc.baoonline.data.model.DataItem
import com.toan_itc.baoonline.ui.common.DataBoundListAdapter

/*
 * Created by Toan.IT on 11/2/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

class HomeListAdapter
//private final HomeClickCallback homeClickCallback;

(private val dataBindingComponent: DataBindingComponent)//this.homeClickCallback = homeClickCallback;
    : DataBoundListAdapter<DataItem, AdapterHomeItemBinding>() {

    override fun createBinding(parent: ViewGroup): AdapterHomeItemBinding {
        val binding = DataBindingUtil.inflate<AdapterHomeItemBinding>(LayoutInflater.from(parent.context),
                R.layout.adapter_home_item, parent, false, dataBindingComponent)
        binding.root.setOnClickListener { v ->
            //Home home = binding.getHome();
            /*   if (home != null && homeClickCallback != null) {
                        homeClickCallback.onClick(home);
                }*/
        }
        return binding
    }

    override fun bind(binding: AdapterHomeItemBinding, item: DataItem) {
        binding.item = item
    }

    override fun areItemsTheSame(oldItem: DataItem?, newItem: DataItem?): Boolean {
        return oldItem?.name == newItem?.name
    }

    override fun areContentsTheSame(oldItem: DataItem?, newItem: DataItem?): Boolean {
        return oldItem?.id == newItem?.id
    }

    interface HomeClickCallback {
        fun onClick(home: DataItem)
    }
}
