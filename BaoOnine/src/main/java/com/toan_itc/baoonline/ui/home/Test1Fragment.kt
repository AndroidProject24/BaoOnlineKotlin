package com.toan_itc.baoonline.ui.home

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.orhanobut.logger.Logger
import com.toan_itc.baoonline.R
import com.toan_itc.baoonline.base.BaseFragment
import com.toan_itc.baoonline.di.Injectable
import com.toan_itc.baoonline.model.Repo
import com.toan_itc.baoonline.network.Status
import com.toan_itc.baoonline.viewmodel.RepoViewModel
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

/**
 * Created by Toan.IT on 10/24/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
class Test1Fragment : BaseFragment(), LifecycleOwner, Injectable {
    companion object {
        fun newInstance() = Test1Fragment()
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var repoViewModel: RepoViewModel

    private val USER_STATE_KEY = "UserName"

    override fun setLayoutResourceID(): Int {
       return R.layout.activity_test;
    }

    override fun initViews() {
        repoViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)
    }

    override fun initData() {

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reposAdapter = ReposAdapter(activity, null)
        recyclerViewRepos.adapter = reposAdapter
        recyclerViewRepos.layoutManager = LinearLayoutManager(activity)
        setupSearchListener(reposAdapter, savedInstanceState)
    }
    private fun setupSearchListener(reposAdapter: ReposAdapter, savedInstanceState: Bundle?) {
        buttonSearch.setOnClickListener({
            repoViewModel.setQuery(editTextUser.text.toString(), reposAdapter.itemCount == 0)
        })
        val currentUserName = savedInstanceState?.get(USER_STATE_KEY) as String?
        repoViewModel.setQuery(currentUserName, reposAdapter.itemCount == 0)
        repoViewModel.repo.observe(this, Observer {
            it?.let {
                textViewError.visibility = View.GONE
                progressBar.visibility = View.GONE
                reposAdapter.updateDataSet(null)
                when (it.status) {
                    Status.SUCCESS -> {
                        Logger.e("data="+it.data.toString())
                        recyclerViewRepos.visibility = View.VISIBLE
                        reposAdapter.updateDataSet(it.data as RealmResults<Repo>)
                    }
                    Status.ERROR -> {
                        textViewError.visibility = View.VISIBLE
                        textViewError.text = it.message
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    //save state
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //get the state from viewModel
        outState?.putString(USER_STATE_KEY, repoViewModel.currentRepoUser)
    }

    internal class ReposAdapter(val context: Context, var repos: RealmResults<Repo>?) : RecyclerView.Adapter<ReposAdapter.RepoItemViewHolder>() {

        override fun getItemCount(): Int {
            return if (repos != null) repos!!.size else 0
        }

        fun updateDataSet(data: RealmResults<Repo>?) {
            repos = data
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): RepoItemViewHolder {
            val textView = TextView(context)
            return RepoItemViewHolder(textView)
        }

        override fun onBindViewHolder(p0: RepoItemViewHolder, p1: Int) {
            p0.bind(repos?.get(p1))
        }

        internal class RepoItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            fun bind(repo: Repo?) = with(itemView) {
                (itemView as TextView).text = repo?.name
            }
        }
    }
}
