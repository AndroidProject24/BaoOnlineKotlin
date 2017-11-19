package com.toan_itc.baoonline.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toan_itc.baoonline.binding.FragmentDataBindingComponent
import com.toan_itc.baoonline.ui.base.ui.BaseFragment
import com.toan_itc.baoonline.ui.common.AutoClearedValue
import com.toan_itc.baoonline.viewmodel.HomeViewModel

/**
 * Created by Toan.IT on 11/2/17.
 * Email:Huynhvantoan.itc@gmail.com
 */

class HomeFragment : BaseFragment(){

    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var binding: AutoClearedValue<FragmentHomeBinding>
    private lateinit var adapter: AutoClearedValue<HomeListAdapter>
    private lateinit var adapter1:AutoClearedValue<HomeListAdapter>
    private lateinit var adapter2:AutoClearedValue<HomeListAdapter>
    private lateinit var adapter3:AutoClearedValue<HomeListAdapter>
    private val viewModel by bindViewModel<HomeViewModel> { viewModelFactory }

    override fun setLayoutResourceID(): Int {
        return R.layout.fragment_home
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentHomeBinding>(inflater, setLayoutResourceID(), container, false).also {
            binding = AutoClearedValue(this, it)
        }.root

    override fun initViewModel() {
        val dataBindingComponent :DataBindingComponent = FragmentDataBindingComponent(this, imageLoaderListener)
        viewModel.setQuery("32", true)
        val songNewAdapter = HomeListAdapter(dataBindingComponent)
        binding.get()?.recyclerSongNew?.adapter = songNewAdapter
        this.adapter = AutoClearedValue(this, songNewAdapter)

        val songRecommendAdapter = HomeListAdapter(dataBindingComponent)
        binding.get()?.recyclerSongRecommend?.adapter = songRecommendAdapter
        this.adapter1 = AutoClearedValue(this, songRecommendAdapter)

        val playlistAdapter = HomeListAdapter(dataBindingComponent)
        binding.get()?.recyclerPlaylist?.adapter = playlistAdapter
        this.adapter2 = AutoClearedValue(this, playlistAdapter)

        val singerAdapter = HomeListAdapter(dataBindingComponent)
        binding.get()?.recyclerSinger?.adapter = singerAdapter
        this.adapter3 = AutoClearedValue(this, singerAdapter)
    }

    override fun initViews() {

    }

    override fun initData() {
        viewModel.results.observer(this){
            it ?: return@observer
            val fragmentHomeBinding = binding.get()
            if (fragmentHomeBinding != null) {
                fragmentHomeBinding.home = it.data
                fragmentHomeBinding.resource = it
                val data=it.data?.data
                //Logger.e("resource=" + data?.song_new?.name)
                adapter.get()?.replace(data?.song_new?.data)
                adapter1.get()?.replace(data?.song_recommend?.data)
                adapter2.get()?.replace(data?.playlist?.data)
                adapter3.get()?.replace(data?.singer?.data)
                fragmentHomeBinding.executePendingBindings()
            }
        }
    }
}
